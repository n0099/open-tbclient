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
    private AlbumActivity apI;
    private View apO;
    private TextView apP;
    private TextView apQ;
    private c apt;
    private View aqA;
    private View aqB;
    private boolean aqC;
    private MediaStoreLoader aqr;
    private RelativeLayout aqs;
    private ImageView aqt;
    private TextView aqu;
    private TextView aqv;
    private com.baidu.live.tieba.write.a.a aqw;
    private TransparentHeadGridView aqx;
    private h aqy;
    private CommonEmptyView aqz;
    private View mView;
    private BlueCircleProgressDialog aqD = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.apt != null) {
                if (view == ImageListFragment.this.aqv) {
                    ImageListFragment.this.aqw.b(ImageListFragment.this.apt.wc(), ImageListFragment.this.apt.wa());
                    ImageListFragment.this.aqw.O(ImageListFragment.this.aqA);
                    ImageListFragment.this.aqv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                    return;
                }
                if (view == ImageListFragment.this.apO) {
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aqv != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aqv.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aqk = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.apt != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.apt.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.apI.cd(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0078a aqE = new a.InterfaceC0078a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0078a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> cS;
            if (ImageListFragment.this.apt != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.apt.wa()) && (cS = ImageListFragment.this.apt.cS(albumId)) != null) {
                    ImageListFragment.this.apt.cQ(albumId);
                    ImageListFragment.this.aqy.setData(cS);
                    if (ImageListFragment.this.aqy.getCount() <= 0) {
                        ImageListFragment.this.aqz.setVisibility(0);
                    } else {
                        ImageListFragment.this.aqz.setVisibility(8);
                    }
                    ImageListFragment.this.aqv.setText(name);
                    ImageListFragment.this.aqx.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aql = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.apI == null || ImageListFragment.this.apt == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.apt.vW()) {
                    ImageListFragment.this.apI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.apt.isAdded(imageFileInfo)) {
                    ImageListFragment.this.apI.b(imageFileInfo);
                } else {
                    ImageListFragment.this.apI.a(imageFileInfo);
                }
                ImageListFragment.this.apt.a((VideoFileInfo) null);
                ImageListFragment.this.aqy.notifyDataSetChanged();
                ImageListFragment.this.wf();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.apt.vV()) {
                    ImageListFragment.this.apI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.apt.b(videoFileInfo)) {
                        ImageListFragment.this.apt.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.apt.a(videoFileInfo);
                    }
                    ImageListFragment.this.apt.vX();
                    ImageListFragment.this.aqy.notifyDataSetChanged();
                    ImageListFragment.this.wf();
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
        this.apI = (AlbumActivity) getBaseFragmentActivity();
        this.apt = this.apI.vG();
        d.we().a(this);
        this.aqr = new MediaStoreLoader(this.apI);
        this.aqw = new com.baidu.live.tieba.write.a.a(this.apI);
        this.aqw.setOnDismissListener(this.mOnDismissListener);
        this.aqw.a(this.aqE);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aqs = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aqA = this.mView.findViewById(a.g.layout_title);
        this.aqv = (TextView) this.mView.findViewById(a.g.album_title);
        this.aqt = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aqu = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aqB = this.mView.findViewById(a.g.navi_line);
        this.apO = this.mView.findViewById(a.g.layout_bottom);
        this.apQ = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.apP = (TextView) this.mView.findViewById(a.g.next_step);
        this.apt.cQ(AlbumData.ALBUM_ID_ALL);
        this.aqv.setText(this.apI.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aqz = new CommonEmptyView(getContext());
        this.aqz.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aqz.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aqz.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aqz.setVisibility(8);
        this.aqz.addToParent(this.aqs);
        this.aqx = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aqx.setSelector(a.d.sdk_transparent);
        this.aqy = new h(this.apI, this.apt);
        this.aqx.setAdapter((ListAdapter) this.aqy);
        this.aqx.setOuterOnScrollListener(this);
        this.aqy.a(this.aql);
        this.aqy.a(this.aqk);
        this.apP.setOnClickListener(this.apI);
        this.aqt.setOnClickListener(this.apI);
        this.aqu.setOnClickListener(this.apI);
        this.apQ.setOnClickListener(this.apI);
        this.aqv.setOnClickListener(this.mOnClickListener);
        this.apO.setOnClickListener(this.mOnClickListener);
        wf();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aqD == null) {
            this.aqD = new BlueCircleProgressDialog(getPageContext());
        }
        this.aqD.setCancelListener(null);
        this.aqD.setTipString(a.i.sdk_loading);
        this.aqD.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.apI.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf() {
        int count;
        String string;
        if (this.apt != null && this.apP != null) {
            if (this.apt.vW()) {
                int i = this.apt.vW() ? 1 : 0;
                count = i;
                string = this.apI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.apt.vY());
                string = this.apI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.apt.getMaxImagesAllowed())});
            }
            this.apP.setText(string);
            this.apP.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aqC = false;
        if (isShow()) {
            vU();
        }
    }

    private void vR() {
        if (this.apt == null && this.apI != null) {
            this.apt = this.apI.vG();
        }
        if (this.apt != null) {
            if (!this.apt.wd()) {
                this.aqy.notifyDataSetChanged();
            } else {
                wg();
            }
            aQ(this.apt.isOriginalImg());
        }
    }

    private void wg() {
        if (this.aqr == null) {
            this.aqr = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aqr.loadAll(this.apI.vF() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aqD != null) {
                    ImageListFragment.this.aqD.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.apt != null && resutMediaStore != null) {
                    ImageListFragment.this.apt.a(resutMediaStore);
                    String wa = ImageListFragment.this.apt.wa();
                    ImageListFragment.this.apt.cQ(wa);
                    ImageListFragment.this.aqy.setData(ImageListFragment.this.apt.cS(wa));
                    if (ImageListFragment.this.aqy.getCount() <= 0) {
                        ImageListFragment.this.aqz.setVisibility(0);
                    } else {
                        ImageListFragment.this.aqz.setVisibility(8);
                    }
                    ImageListFragment.this.aqx.smoothScrollToPosition(0);
                    ImageListFragment.this.wf();
                }
                ImageListFragment.this.aqx.wi();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aqB, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aqv, a.d.sdk_cp_cont_b, i);
        if (this.apI.vF() == 1) {
            SkinManager.setImageResource(this.aqt, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aqu.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aqu, a.d.sdk_ph_navi_back_text_color);
            this.aqt.setVisibility(8);
        }
        if (this.aqv != null) {
            this.aqv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aqy != null) {
            this.aqy.notifyDataSetChanged();
        }
        if (this.apt != null) {
            aQ(this.apt.isOriginalImg());
        }
    }

    public View vS() {
        return this.apI.vF() == 1 ? this.aqt : this.aqu;
    }

    public View wh() {
        return this.apP;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aqw != null) {
            this.aqw.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aqr != null) {
            this.aqr.cancelLoadTask();
        }
        if (this.apI != null) {
            this.apI.closeLoadingDialog();
        }
        if (this.aqD != null) {
            this.aqD.setDialogVisiable(false);
        }
        d.we().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aqC = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void aS(boolean z) {
        vU();
    }

    private void vU() {
        if (!isHidden() && !this.aqC) {
            vR();
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
            this.aqy.aT(true);
        } else if (this.aqy.isScroll()) {
            this.aqy.aT(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.aqx != null) {
            int firstVisiblePosition = this.aqx.getFirstVisiblePosition();
            int lastVisiblePosition = this.aqx.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aqx.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aqy != null) {
                    this.aqy.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        wf();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aqy != null) {
            i(this.aqy.e(imageFileInfo), z);
        }
    }

    public View vO() {
        return this.apQ;
    }

    public void aQ(boolean z) {
        if (this.apI != null && this.apQ != null) {
            this.apQ.setText(this.apI.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.apQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.apQ, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.apQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.apQ, a.d.sdk_cp_cont_f);
        }
    }
}
