package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private View aCC;
    private TextView aCD;
    private TextView aCE;
    private c aCi;
    private AlbumActivity aCw;
    private MediaStoreLoader aDe;
    private RelativeLayout aDf;
    private ImageView aDg;
    private TextView aDh;
    private TextView aDi;
    private com.baidu.live.tieba.write.a.a aDj;
    private TransparentHeadGridView aDk;
    private h aDl;
    private CommonEmptyView aDm;
    private View aDn;
    private View aDo;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog aDp = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.aCi != null) {
                if (view == ImageListFragment.this.aDi) {
                    ImageListFragment.this.aDj.b(ImageListFragment.this.aCi.AR(), ImageListFragment.this.aCi.AP());
                    ImageListFragment.this.aDj.R(ImageListFragment.this.aDn);
                    ImageListFragment.this.aDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.aCC) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.aDi != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.aDi.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f aCX = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.aCi != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.aCi.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.aCw.cM(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0101a aDq = new a.InterfaceC0101a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0101a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> eb;
            if (ImageListFragment.this.aCi != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.aCi.AP()) && (eb = ImageListFragment.this.aCi.eb(albumId)) != null) {
                    ImageListFragment.this.aCi.dZ(albumId);
                    ImageListFragment.this.aDl.setData(eb);
                    if (ImageListFragment.this.aDl.getCount() <= 0) {
                        ImageListFragment.this.aDm.setVisibility(0);
                    } else {
                        ImageListFragment.this.aDm.setVisibility(8);
                    }
                    ImageListFragment.this.aDi.setText(name);
                    ImageListFragment.this.aDk.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g aCY = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.aCw == null || ImageListFragment.this.aCi == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.aCi.AL()) {
                    ImageListFragment.this.aCw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.aCi.isAdded(imageFileInfo)) {
                    ImageListFragment.this.aCw.b(imageFileInfo);
                } else {
                    ImageListFragment.this.aCw.a(imageFileInfo);
                }
                ImageListFragment.this.aCi.a((VideoFileInfo) null);
                ImageListFragment.this.aDl.notifyDataSetChanged();
                ImageListFragment.this.AU();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.aCi.AK()) {
                    ImageListFragment.this.aCw.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.aCi.b(videoFileInfo)) {
                        ImageListFragment.this.aCi.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.aCi.a(videoFileInfo);
                    }
                    ImageListFragment.this.aCi.AM();
                    ImageListFragment.this.aDl.notifyDataSetChanged();
                    ImageListFragment.this.AU();
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
        this.aCw = (AlbumActivity) getBaseFragmentActivity();
        this.aCi = this.aCw.Av();
        d.AT().a(this);
        this.aDe = new MediaStoreLoader(this.aCw);
        this.aDj = new com.baidu.live.tieba.write.a.a(this.aCw);
        this.aDj.setOnDismissListener(this.mOnDismissListener);
        this.aDj.a(this.aDq);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.aDf = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.aDn = this.mView.findViewById(a.g.layout_title);
        this.aDi = (TextView) this.mView.findViewById(a.g.album_title);
        this.aDg = (ImageView) this.mView.findViewById(a.g.img_close);
        this.aDh = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.aDo = this.mView.findViewById(a.g.navi_line);
        this.aCC = this.mView.findViewById(a.g.layout_bottom);
        this.aCE = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.aCD = (TextView) this.mView.findViewById(a.g.next_step);
        this.aCi.dZ(AlbumData.ALBUM_ID_ALL);
        this.aDi.setText(this.aCw.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.aDm = new CommonEmptyView(getContext());
        this.aDm.setTitle(a.i.sdk_ph_album_list_no_data);
        this.aDm.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.aDm.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.aDm.setVisibility(8);
        this.aDm.addToParent(this.aDf);
        this.aDk = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.aDk.setSelector(a.d.sdk_transparent);
        this.aDl = new h(this.aCw, this.aCi);
        this.aDk.setAdapter((ListAdapter) this.aDl);
        this.aDk.setOuterOnScrollListener(this);
        this.aDl.a(this.aCY);
        this.aDl.a(this.aCX);
        this.aCD.setOnClickListener(this.aCw);
        this.aDg.setOnClickListener(this.aCw);
        this.aDh.setOnClickListener(this.aCw);
        this.aCE.setOnClickListener(this.aCw);
        this.aDi.setOnClickListener(this.mOnClickListener);
        this.aCC.setOnClickListener(this.mOnClickListener);
        AU();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aDp == null) {
            this.aDp = new BlueCircleProgressDialog(getPageContext());
        }
        this.aDp.setCancelListener(null);
        this.aDp.setTipString(a.i.sdk_loading);
        this.aDp.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.aCw.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        int count;
        String string;
        if (this.aCi != null && this.aCD != null) {
            if (this.aCi.AL()) {
                int i = this.aCi.AL() ? 1 : 0;
                count = i;
                string = this.aCw.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.aCi.AN());
                string = this.aCw.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aCi.getMaxImagesAllowed())});
            }
            this.aCD.setText(string);
            this.aCD.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            AJ();
        }
    }

    private void AG() {
        if (this.aCi == null && this.aCw != null) {
            this.aCi = this.aCw.Av();
        }
        if (this.aCi != null) {
            if (!this.aCi.AS()) {
                this.aDl.notifyDataSetChanged();
            } else {
                AV();
            }
            bu(this.aCi.isOriginalImg());
        }
    }

    private void AV() {
        if (this.aDe == null) {
            this.aDe = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.aDe.loadAll(this.aCw.Au() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aDp != null) {
                    ImageListFragment.this.aDp.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.aCi != null && resutMediaStore != null) {
                    ImageListFragment.this.aCi.a(resutMediaStore);
                    String AP = ImageListFragment.this.aCi.AP();
                    ImageListFragment.this.aCi.dZ(AP);
                    ImageListFragment.this.aDl.setData(ImageListFragment.this.aCi.eb(AP));
                    if (ImageListFragment.this.aDl.getCount() <= 0) {
                        ImageListFragment.this.aDm.setVisibility(0);
                    } else {
                        ImageListFragment.this.aDm.setVisibility(8);
                    }
                    ImageListFragment.this.aDk.smoothScrollToPosition(0);
                    ImageListFragment.this.AU();
                }
                ImageListFragment.this.aDk.AX();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.aDo, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.aDi, a.d.sdk_cp_cont_b, i);
        if (this.aCw.Au() == 1) {
            SkinManager.setImageResource(this.aDg, a.f.sdk_ph_icon_topbar_close_n, i);
            this.aDh.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.aDh, a.d.sdk_ph_navi_back_text_color);
            this.aDg.setVisibility(8);
        }
        if (this.aDi != null) {
            this.aDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.aDl != null) {
            this.aDl.notifyDataSetChanged();
        }
        if (this.aCi != null) {
            bu(this.aCi.isOriginalImg());
        }
    }

    public View AH() {
        return this.aCw.Au() == 1 ? this.aDg : this.aDh;
    }

    public View AW() {
        return this.aCD;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.aDj != null) {
            this.aDj.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aDe != null) {
            this.aDe.cancelLoadTask();
        }
        if (this.aCw != null) {
            this.aCw.closeLoadingDialog();
        }
        if (this.aDp != null) {
            this.aDp.setDialogVisiable(false);
        }
        d.AT().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void bw(boolean z) {
        AJ();
    }

    private void AJ() {
        if (!isHidden() && !this.isPaused) {
            AG();
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
            this.aDl.bx(true);
        } else if (this.aDl.isScroll()) {
            this.aDl.bx(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.aDk != null) {
            int firstVisiblePosition = this.aDk.getFirstVisiblePosition();
            int lastVisiblePosition = this.aDk.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.aDk.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.aDl != null) {
                    this.aDl.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        AU();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.aDl != null) {
            i(this.aDl.e(imageFileInfo), z);
        }
    }

    public View AD() {
        return this.aCE;
    }

    public void bu(boolean z) {
        if (this.aCw != null && this.aCE != null) {
            this.aCE.setText(this.aCw.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.aCE.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.aCE, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.aCE.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.aCE, a.d.sdk_cp_cont_f);
        }
    }
}
