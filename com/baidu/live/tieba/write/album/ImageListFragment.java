package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.MediaStoreLoadCallback;
import com.baidu.live.tbadk.album.MediaStoreLoader;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.write.a.a;
import com.baidu.live.tieba.write.album.d;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private MediaStoreLoader apZ;
    private c apa;
    private AlbumActivity apq;
    private View apw;
    private TextView apx;
    private TextView apy;
    private RelativeLayout aqa;
    private ImageView aqb;
    private TextView aqc;
    private TextView aqd;
    private com.baidu.live.tieba.write.a.a aqe;
    private TransparentHeadGridView aqf;
    private h aqg;
    private CommonEmptyView aqh;
    private View aqi;
    private View aqj;
    private boolean aqk;
    private View mView;
    private BlueCircleProgressDialog aql = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.apa != null) {
                if (view == ImageListFragment.this.aqd) {
                    ImageListFragment.this.aqe.b(ImageListFragment.this.apa.wd(), ImageListFragment.this.apa.wb());
                    ImageListFragment.this.aqe.O(ImageListFragment.this.aqi);
                    ImageListFragment.this.aqd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                    return;
                }
                if (view == ImageListFragment.this.apw) {
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aqd != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aqd.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f apS = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.apa != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.apa.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.apq.cd(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0078a aqm = new a.InterfaceC0078a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0078a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> cS;
            if (ImageListFragment.this.apa != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.apa.wb()) && (cS = ImageListFragment.this.apa.cS(albumId)) != null) {
                    ImageListFragment.this.apa.cQ(albumId);
                    ImageListFragment.this.aqg.setData(cS);
                    if (ImageListFragment.this.aqg.getCount() <= 0) {
                        ImageListFragment.this.aqh.setVisibility(0);
                    } else {
                        ImageListFragment.this.aqh.setVisibility(8);
                    }
                    ImageListFragment.this.aqd.setText(name);
                    ImageListFragment.this.aqf.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g apT = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.apq == null || ImageListFragment.this.apa == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.apa.vX()) {
                    ImageListFragment.this.apq.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.apa.isAdded(imageFileInfo)) {
                    ImageListFragment.this.apq.b(imageFileInfo);
                } else {
                    ImageListFragment.this.apq.a(imageFileInfo);
                }
                ImageListFragment.this.apa.a((VideoFileInfo) null);
                ImageListFragment.this.aqg.notifyDataSetChanged();
                ImageListFragment.this.wg();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.apa.vW()) {
                    ImageListFragment.this.apq.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.apa.b(videoFileInfo)) {
                        ImageListFragment.this.apa.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.apa.a(videoFileInfo);
                    }
                    ImageListFragment.this.apa.vY();
                    ImageListFragment.this.aqg.notifyDataSetChanged();
                    ImageListFragment.this.wg();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apq = (AlbumActivity) getBaseFragmentActivity();
        this.apa = this.apq.vH();
        d.wf().a(this);
        this.apZ = new MediaStoreLoader(this.apq);
        this.aqe = new com.baidu.live.tieba.write.a.a(this.apq);
        this.aqe.setOnDismissListener(this.mOnDismissListener);
        this.aqe.a(this.aqm);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aqa = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aqi = this.mView.findViewById(a.g.layout_title);
        this.aqd = (TextView) this.mView.findViewById(a.g.album_title);
        this.aqb = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aqc = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aqj = this.mView.findViewById(a.g.navi_line);
        this.apw = this.mView.findViewById(a.g.layout_bottom);
        this.apy = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.apx = (TextView) this.mView.findViewById(a.g.next_step);
        this.apa.cQ(AlbumData.ALBUM_ID_ALL);
        this.aqd.setText(this.apq.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aqh = new CommonEmptyView(getContext());
        this.aqh.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aqh.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aqh.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aqh.setVisibility(8);
        this.aqh.addToParent(this.aqa);
        this.aqf = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aqf.setSelector(a.d.sdk_transparent);
        this.aqg = new h(this.apq, this.apa);
        this.aqf.setAdapter((ListAdapter) this.aqg);
        this.aqf.setOuterOnScrollListener(this);
        this.aqg.a(this.apT);
        this.aqg.a(this.apS);
        this.apx.setOnClickListener(this.apq);
        this.aqb.setOnClickListener(this.apq);
        this.aqc.setOnClickListener(this.apq);
        this.apy.setOnClickListener(this.apq);
        this.aqd.setOnClickListener(this.mOnClickListener);
        this.apw.setOnClickListener(this.mOnClickListener);
        wg();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aql == null) {
            this.aql = new BlueCircleProgressDialog(getPageContext());
        }
        this.aql.setCancelListener(null);
        this.aql.setTipString(a.i.sdk_loading);
        this.aql.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.apq.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg() {
        int count;
        String string;
        if (this.apa != null && this.apx != null) {
            if (this.apa.vX()) {
                int i = this.apa.vX() ? 1 : 0;
                count = i;
                string = this.apq.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.apa.vZ());
                string = this.apq.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.apa.getMaxImagesAllowed())});
            }
            this.apx.setText(string);
            this.apx.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aqk = false;
        if (isShow()) {
            vV();
        }
    }

    private void vS() {
        if (this.apa == null && this.apq != null) {
            this.apa = this.apq.vH();
        }
        if (this.apa != null) {
            if (!this.apa.we()) {
                this.aqg.notifyDataSetChanged();
            } else {
                wh();
            }
            aQ(this.apa.isOriginalImg());
        }
    }

    private void wh() {
        if (this.apZ == null) {
            this.apZ = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.apZ.loadAll(this.apq.vG() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aql != null) {
                    ImageListFragment.this.aql.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.apa != null && resutMediaStore != null) {
                    ImageListFragment.this.apa.a(resutMediaStore);
                    String wb = ImageListFragment.this.apa.wb();
                    ImageListFragment.this.apa.cQ(wb);
                    ImageListFragment.this.aqg.setData(ImageListFragment.this.apa.cS(wb));
                    if (ImageListFragment.this.aqg.getCount() <= 0) {
                        ImageListFragment.this.aqh.setVisibility(0);
                    } else {
                        ImageListFragment.this.aqh.setVisibility(8);
                    }
                    ImageListFragment.this.aqf.smoothScrollToPosition(0);
                    ImageListFragment.this.wg();
                }
                ImageListFragment.this.aqf.wj();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aqj, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aqd, a.d.sdk_cp_cont_b, i);
        if (this.apq.vG() == 1) {
            SkinManager.setImageResource(this.aqb, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aqc.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aqc, a.d.sdk_ph_navi_back_text_color);
            this.aqb.setVisibility(8);
        }
        if (this.aqd != null) {
            this.aqd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aqg != null) {
            this.aqg.notifyDataSetChanged();
        }
        if (this.apa != null) {
            aQ(this.apa.isOriginalImg());
        }
    }

    public View vT() {
        return this.apq.vG() == 1 ? this.aqb : this.aqc;
    }

    public View wi() {
        return this.apx;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aqe != null) {
            this.aqe.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.apZ != null) {
            this.apZ.cancelLoadTask();
        }
        if (this.apq != null) {
            this.apq.closeLoadingDialog();
        }
        if (this.aql != null) {
            this.aql.setDialogVisiable(false);
        }
        d.wf().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aqk = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void aS(boolean z) {
        vV();
    }

    private void vV() {
        if (!isHidden() && !this.aqk) {
            vS();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.aqg.aT(true);
        } else if (this.aqg.isScroll()) {
            this.aqg.aT(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.aqf != null) {
            int firstVisiblePosition = this.aqf.getFirstVisiblePosition();
            int lastVisiblePosition = this.aqf.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aqf.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aqg != null) {
                    this.aqg.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        wg();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aqg != null) {
            i(this.aqg.e(imageFileInfo), z);
        }
    }

    public View vP() {
        return this.apy;
    }

    public void aQ(boolean z) {
        if (this.apq != null && this.apy != null) {
            this.apy.setText(this.apq.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.apy.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.apy, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.apy.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.apy, a.d.sdk_cp_cont_f);
        }
    }
}
