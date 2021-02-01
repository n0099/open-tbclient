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
/* loaded from: classes11.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private c bLb;
    private AlbumActivity bLp;
    private View bLs;
    private TextView bLt;
    private TextView bLu;
    private MediaStoreLoader bMc;
    private RelativeLayout bMd;
    private ImageView bMe;
    private TextView bMf;
    private TextView bMg;
    private com.baidu.live.tieba.write.a.a bMh;
    private TransparentHeadGridView bMi;
    private i bMj;
    private CommonEmptyView bMk;
    private View bMl;
    private View bMm;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog bMn = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bLb != null) {
                if (view == ImageListFragment.this.bMg) {
                    ImageListFragment.this.bMh.setData(ImageListFragment.this.bLb.UK(), ImageListFragment.this.bLb.UI());
                    ImageListFragment.this.bMh.O(ImageListFragment.this.bMl);
                    ImageListFragment.this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bLs) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bMg != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bMg.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bLV = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bLb != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bLb.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bLp.eP(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0218a bMo = new a.InterfaceC0218a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0218a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hV;
            if (ImageListFragment.this.bLb != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bLb.UI()) && (hV = ImageListFragment.this.bLb.hV(albumId)) != null) {
                    ImageListFragment.this.bLb.hT(albumId);
                    ImageListFragment.this.bMj.setData(hV);
                    if (ImageListFragment.this.bMj.getCount() <= 0) {
                        ImageListFragment.this.bMk.setVisibility(0);
                    } else {
                        ImageListFragment.this.bMk.setVisibility(8);
                    }
                    ImageListFragment.this.bMg.setText(name);
                    ImageListFragment.this.bMi.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bLW = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bLp == null || ImageListFragment.this.bLb == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bLb.UE()) {
                    ImageListFragment.this.bLp.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bLb.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bLp.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bLp.a(imageFileInfo);
                }
                ImageListFragment.this.bLb.a((VideoFileInfo) null);
                ImageListFragment.this.bMj.notifyDataSetChanged();
                ImageListFragment.this.UO();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bLb.UD()) {
                    ImageListFragment.this.bLp.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bLb.b(videoFileInfo)) {
                        ImageListFragment.this.bLb.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bLb.a(videoFileInfo);
                    }
                    ImageListFragment.this.bLb.UF();
                    ImageListFragment.this.bMj.notifyDataSetChanged();
                    ImageListFragment.this.UO();
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
        this.bLp = (AlbumActivity) getBaseFragmentActivity();
        this.bLb = this.bLp.Uo();
        d.UL().a(this);
        this.bMc = new MediaStoreLoader(this.bLp);
        this.bMh = new com.baidu.live.tieba.write.a.a(this.bLp);
        this.bMh.setOnDismissListener(this.mOnDismissListener);
        this.bMh.a(this.bMo);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bMd = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bMl = this.mView.findViewById(a.f.layout_title);
        this.bMg = (TextView) this.mView.findViewById(a.f.album_title);
        this.bMe = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bMf = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bMm = this.mView.findViewById(a.f.navi_line);
        this.bLs = this.mView.findViewById(a.f.layout_bottom);
        this.bLu = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bLt = (TextView) this.mView.findViewById(a.f.next_step);
        this.bLb.hT(AlbumData.ALBUM_ID_ALL);
        this.bMg.setText(this.bLp.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bMk = new CommonEmptyView(getContext());
        this.bMk.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bMk.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bMk.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bMk.setVisibility(8);
        this.bMk.addToParent(this.bMd);
        this.bMi = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bMi.setSelector(a.c.sdk_transparent);
        this.bMj = new i(this.bLp, this.bLb);
        this.bMi.setAdapter((ListAdapter) this.bMj);
        this.bMi.setOuterOnScrollListener(this);
        this.bMj.a(this.bLW);
        this.bMj.a(this.bLV);
        this.bLt.setOnClickListener(this.bLp);
        this.bMe.setOnClickListener(this.bLp);
        this.bMf.setOnClickListener(this.bLp);
        this.bLu.setOnClickListener(this.bLp);
        this.bMg.setOnClickListener(this.mOnClickListener);
        this.bLs.setOnClickListener(this.mOnClickListener);
        UO();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bMn == null) {
            this.bMn = new BlueCircleProgressDialog(getPageContext());
        }
        this.bMn.setCancelListener(null);
        this.bMn.setTipString(a.h.sdk_loading);
        this.bMn.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bLp.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UO() {
        int count;
        String string;
        if (this.bLb != null && this.bLt != null) {
            if (this.bLb.UE()) {
                int i = this.bLb.UE() ? 1 : 0;
                string = this.bLp.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bLb.UG());
                string = this.bLp.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bLb.getMaxImagesAllowed())});
            }
            this.bLt.setText(string);
            this.bLt.setEnabled(count > 0);
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
            Ut();
        }
    }

    private void Us() {
        if (this.bLb == null && this.bLp != null) {
            this.bLb = this.bLp.Uo();
        }
        if (this.bLb != null) {
            UP();
            dn(this.bLb.isOriginalImg());
        }
    }

    private void UP() {
        if (this.bMc == null) {
            this.bMc = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bMc.loadAll(this.bLp.Un() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bMn != null) {
                    ImageListFragment.this.bMn.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bLb != null && resutMediaStore != null) {
                    ImageListFragment.this.bLb.a(resutMediaStore);
                    String UI = ImageListFragment.this.bLb.UI();
                    ImageListFragment.this.bLb.hT(UI);
                    ImageListFragment.this.bMj.setData(ImageListFragment.this.bLb.hV(UI));
                    if (ImageListFragment.this.bMj.getCount() <= 0) {
                        ImageListFragment.this.bMk.setVisibility(0);
                    } else {
                        ImageListFragment.this.bMk.setVisibility(8);
                    }
                    ImageListFragment.this.bMi.smoothScrollToPosition(0);
                    ImageListFragment.this.UO();
                }
                ImageListFragment.this.bMi.UR();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bMm, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bMg, a.c.sdk_cp_cont_b, i);
        if (this.bLp.Un() == 1) {
            SkinManager.setImageResource(this.bMe, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bMf.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bMf, a.c.sdk_ph_navi_back_text_color);
            this.bMe.setVisibility(8);
        }
        if (this.bMg != null) {
            this.bMg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bMj != null) {
            this.bMj.notifyDataSetChanged();
        }
        if (this.bLb != null) {
            dn(this.bLb.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bMh != null) {
            this.bMh.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bMc != null) {
            this.bMc.cancelLoadTask();
        }
        if (this.bLp != null) {
            this.bLp.closeLoadingDialog();
        }
        if (this.bMn != null) {
            this.bMn.setDialogVisiable(false);
        }
        d.UL().b(this);
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
        Ut();
    }

    private void Ut() {
        if (!isHidden() && !this.isPaused) {
            Us();
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
            this.bMj.dq(true);
        } else if (this.bMj.isScroll()) {
            this.bMj.dq(false);
        }
    }

    public void dn(boolean z) {
        if (this.bLp != null && this.bLu != null) {
            this.bLu.setText(this.bLp.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_cont_f);
        }
    }
}
