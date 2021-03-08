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
import com.baidu.live.sdk.a;
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
/* loaded from: classes10.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private c bMB;
    private AlbumActivity bMP;
    private View bMS;
    private TextView bMT;
    private TextView bMU;
    private MediaStoreLoader bNC;
    private RelativeLayout bND;
    private ImageView bNE;
    private TextView bNF;
    private TextView bNG;
    private com.baidu.live.tieba.write.a.a bNH;
    private TransparentHeadGridView bNI;
    private i bNJ;
    private CommonEmptyView bNK;
    private View bNL;
    private View bNM;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog bNN = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bMB != null) {
                if (view == ImageListFragment.this.bNG) {
                    ImageListFragment.this.bNH.setData(ImageListFragment.this.bMB.UN(), ImageListFragment.this.bMB.UL());
                    ImageListFragment.this.bNH.O(ImageListFragment.this.bNL);
                    ImageListFragment.this.bNG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bMS) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bNG != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bNG.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bNv = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bMB != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bMB.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bMP.eQ(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0224a bNO = new a.InterfaceC0224a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0224a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ib;
            if (ImageListFragment.this.bMB != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bMB.UL()) && (ib = ImageListFragment.this.bMB.ib(albumId)) != null) {
                    ImageListFragment.this.bMB.hZ(albumId);
                    ImageListFragment.this.bNJ.setData(ib);
                    if (ImageListFragment.this.bNJ.getCount() <= 0) {
                        ImageListFragment.this.bNK.setVisibility(0);
                    } else {
                        ImageListFragment.this.bNK.setVisibility(8);
                    }
                    ImageListFragment.this.bNG.setText(name);
                    ImageListFragment.this.bNI.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bNw = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bMP == null || ImageListFragment.this.bMB == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bMB.UH()) {
                    ImageListFragment.this.bMP.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bMB.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bMP.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bMP.a(imageFileInfo);
                }
                ImageListFragment.this.bMB.a((VideoFileInfo) null);
                ImageListFragment.this.bNJ.notifyDataSetChanged();
                ImageListFragment.this.UR();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bMB.UG()) {
                    ImageListFragment.this.bMP.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bMB.b(videoFileInfo)) {
                        ImageListFragment.this.bMB.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bMB.a(videoFileInfo);
                    }
                    ImageListFragment.this.bMB.UI();
                    ImageListFragment.this.bNJ.notifyDataSetChanged();
                    ImageListFragment.this.UR();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMP = (AlbumActivity) getBaseFragmentActivity();
        this.bMB = this.bMP.Ur();
        d.UO().a(this);
        this.bNC = new MediaStoreLoader(this.bMP);
        this.bNH = new com.baidu.live.tieba.write.a.a(this.bMP);
        this.bNH.setOnDismissListener(this.mOnDismissListener);
        this.bNH.a(this.bNO);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bND = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bNL = this.mView.findViewById(a.f.layout_title);
        this.bNG = (TextView) this.mView.findViewById(a.f.album_title);
        this.bNE = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bNF = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bNM = this.mView.findViewById(a.f.navi_line);
        this.bMS = this.mView.findViewById(a.f.layout_bottom);
        this.bMU = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bMT = (TextView) this.mView.findViewById(a.f.next_step);
        this.bMB.hZ(AlbumData.ALBUM_ID_ALL);
        this.bNG.setText(this.bMP.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bNK = new CommonEmptyView(getContext());
        this.bNK.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bNK.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bNK.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bNK.setVisibility(8);
        this.bNK.addToParent(this.bND);
        this.bNI = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bNI.setSelector(a.c.sdk_transparent);
        this.bNJ = new i(this.bMP, this.bMB);
        this.bNI.setAdapter((ListAdapter) this.bNJ);
        this.bNI.setOuterOnScrollListener(this);
        this.bNJ.a(this.bNw);
        this.bNJ.a(this.bNv);
        this.bMT.setOnClickListener(this.bMP);
        this.bNE.setOnClickListener(this.bMP);
        this.bNF.setOnClickListener(this.bMP);
        this.bMU.setOnClickListener(this.bMP);
        this.bNG.setOnClickListener(this.mOnClickListener);
        this.bMS.setOnClickListener(this.mOnClickListener);
        UR();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bNN == null) {
            this.bNN = new BlueCircleProgressDialog(getPageContext());
        }
        this.bNN.setCancelListener(null);
        this.bNN.setTipString(a.h.sdk_loading);
        this.bNN.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bMP.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UR() {
        int count;
        String string;
        if (this.bMB != null && this.bMT != null) {
            if (this.bMB.UH()) {
                int i = this.bMB.UH() ? 1 : 0;
                string = this.bMP.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bMB.UJ());
                string = this.bMP.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bMB.getMaxImagesAllowed())});
            }
            this.bMT.setText(string);
            this.bMT.setEnabled(count > 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (isShow()) {
            Uw();
        }
    }

    private void Uv() {
        if (this.bMB == null && this.bMP != null) {
            this.bMB = this.bMP.Ur();
        }
        if (this.bMB != null) {
            US();
            dn(this.bMB.isOriginalImg());
        }
    }

    private void US() {
        if (this.bNC == null) {
            this.bNC = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bNC.loadAll(this.bMP.Uq() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bNN != null) {
                    ImageListFragment.this.bNN.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bMB != null && resutMediaStore != null) {
                    ImageListFragment.this.bMB.a(resutMediaStore);
                    String UL = ImageListFragment.this.bMB.UL();
                    ImageListFragment.this.bMB.hZ(UL);
                    ImageListFragment.this.bNJ.setData(ImageListFragment.this.bMB.ib(UL));
                    if (ImageListFragment.this.bNJ.getCount() <= 0) {
                        ImageListFragment.this.bNK.setVisibility(0);
                    } else {
                        ImageListFragment.this.bNK.setVisibility(8);
                    }
                    ImageListFragment.this.bNI.smoothScrollToPosition(0);
                    ImageListFragment.this.UR();
                }
                ImageListFragment.this.bNI.UU();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bNM, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bNG, a.c.sdk_cp_cont_b, i);
        if (this.bMP.Uq() == 1) {
            SkinManager.setImageResource(this.bNE, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bNF.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bNF, a.c.sdk_ph_navi_back_text_color);
            this.bNE.setVisibility(8);
        }
        if (this.bNG != null) {
            this.bNG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bNJ != null) {
            this.bNJ.notifyDataSetChanged();
        }
        if (this.bMB != null) {
            dn(this.bMB.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bNH != null) {
            this.bNH.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bNC != null) {
            this.bNC.cancelLoadTask();
        }
        if (this.bMP != null) {
            this.bMP.closeLoadingDialog();
        }
        if (this.bNN != null) {
            this.bNN.setDialogVisiable(false);
        }
        d.UO().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void dp(boolean z) {
        Uw();
    }

    private void Uw() {
        if (!isHidden() && !this.isPaused) {
            Uv();
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
            this.bNJ.dq(true);
        } else if (this.bNJ.isScroll()) {
            this.bNJ.dq(false);
        }
    }

    public void dn(boolean z) {
        if (this.bMP != null && this.bMU != null) {
            this.bMU.setText(this.bMP.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bMU.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bMU, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bMU.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bMU, a.c.sdk_cp_cont_f);
        }
    }
}
