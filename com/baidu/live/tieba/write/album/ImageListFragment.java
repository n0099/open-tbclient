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
    private AlbumActivity bHF;
    private View bHI;
    private TextView bHJ;
    private TextView bHK;
    private c bHr;
    private CommonEmptyView bIA;
    private View bIB;
    private View bIC;
    private MediaStoreLoader bIs;
    private RelativeLayout bIt;
    private ImageView bIu;
    private TextView bIv;
    private TextView bIw;
    private com.baidu.live.tieba.write.a.a bIx;
    private TransparentHeadGridView bIy;
    private i bIz;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog bID = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bHr != null) {
                if (view == ImageListFragment.this.bIw) {
                    ImageListFragment.this.bIx.c(ImageListFragment.this.bHr.Td(), ImageListFragment.this.bHr.Tb());
                    ImageListFragment.this.bIx.O(ImageListFragment.this.bIB);
                    ImageListFragment.this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bHI) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bIw != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bIw.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bIl = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bHr != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bHr.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bHF.eL(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0216a bIE = new a.InterfaceC0216a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0216a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hz;
            if (ImageListFragment.this.bHr != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bHr.Tb()) && (hz = ImageListFragment.this.bHr.hz(albumId)) != null) {
                    ImageListFragment.this.bHr.hx(albumId);
                    ImageListFragment.this.bIz.setData(hz);
                    if (ImageListFragment.this.bIz.getCount() <= 0) {
                        ImageListFragment.this.bIA.setVisibility(0);
                    } else {
                        ImageListFragment.this.bIA.setVisibility(8);
                    }
                    ImageListFragment.this.bIw.setText(name);
                    ImageListFragment.this.bIy.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bIm = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bHF == null || ImageListFragment.this.bHr == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bHr.SX()) {
                    ImageListFragment.this.bHF.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bHr.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bHF.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bHF.a(imageFileInfo);
                }
                ImageListFragment.this.bHr.a((VideoFileInfo) null);
                ImageListFragment.this.bIz.notifyDataSetChanged();
                ImageListFragment.this.Th();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bHr.SW()) {
                    ImageListFragment.this.bHF.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bHr.b(videoFileInfo)) {
                        ImageListFragment.this.bHr.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bHr.a(videoFileInfo);
                    }
                    ImageListFragment.this.bHr.SY();
                    ImageListFragment.this.bIz.notifyDataSetChanged();
                    ImageListFragment.this.Th();
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
        this.bHF = (AlbumActivity) getBaseFragmentActivity();
        this.bHr = this.bHF.SH();
        d.Te().a(this);
        this.bIs = new MediaStoreLoader(this.bHF);
        this.bIx = new com.baidu.live.tieba.write.a.a(this.bHF);
        this.bIx.setOnDismissListener(this.mOnDismissListener);
        this.bIx.a(this.bIE);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bIt = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bIB = this.mView.findViewById(a.f.layout_title);
        this.bIw = (TextView) this.mView.findViewById(a.f.album_title);
        this.bIu = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bIv = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bIC = this.mView.findViewById(a.f.navi_line);
        this.bHI = this.mView.findViewById(a.f.layout_bottom);
        this.bHK = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bHJ = (TextView) this.mView.findViewById(a.f.next_step);
        this.bHr.hx(AlbumData.ALBUM_ID_ALL);
        this.bIw.setText(this.bHF.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bIA = new CommonEmptyView(getContext());
        this.bIA.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bIA.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bIA.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bIA.setVisibility(8);
        this.bIA.addToParent(this.bIt);
        this.bIy = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bIy.setSelector(a.c.sdk_transparent);
        this.bIz = new i(this.bHF, this.bHr);
        this.bIy.setAdapter((ListAdapter) this.bIz);
        this.bIy.setOuterOnScrollListener(this);
        this.bIz.a(this.bIm);
        this.bIz.a(this.bIl);
        this.bHJ.setOnClickListener(this.bHF);
        this.bIu.setOnClickListener(this.bHF);
        this.bIv.setOnClickListener(this.bHF);
        this.bHK.setOnClickListener(this.bHF);
        this.bIw.setOnClickListener(this.mOnClickListener);
        this.bHI.setOnClickListener(this.mOnClickListener);
        Th();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bID == null) {
            this.bID = new BlueCircleProgressDialog(getPageContext());
        }
        this.bID.setCancelListener(null);
        this.bID.setTipString(a.h.sdk_loading);
        this.bID.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bHF.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        int count;
        String string;
        if (this.bHr != null && this.bHJ != null) {
            if (this.bHr.SX()) {
                int i = this.bHr.SX() ? 1 : 0;
                string = this.bHF.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
                count = i;
            } else {
                count = ListUtils.getCount(this.bHr.SZ());
                string = this.bHF.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bHr.getMaxImagesAllowed())});
            }
            this.bHJ.setText(string);
            this.bHJ.setEnabled(count > 0);
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
            SM();
        }
    }

    private void SL() {
        if (this.bHr == null && this.bHF != null) {
            this.bHr = this.bHF.SH();
        }
        if (this.bHr != null) {
            Ti();
            df(this.bHr.isOriginalImg());
        }
    }

    private void Ti() {
        if (this.bIs == null) {
            this.bIs = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bIs.loadAll(this.bHF.SG() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bID != null) {
                    ImageListFragment.this.bID.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bHr != null && resutMediaStore != null) {
                    ImageListFragment.this.bHr.a(resutMediaStore);
                    String Tb = ImageListFragment.this.bHr.Tb();
                    ImageListFragment.this.bHr.hx(Tb);
                    ImageListFragment.this.bIz.setData(ImageListFragment.this.bHr.hz(Tb));
                    if (ImageListFragment.this.bIz.getCount() <= 0) {
                        ImageListFragment.this.bIA.setVisibility(0);
                    } else {
                        ImageListFragment.this.bIA.setVisibility(8);
                    }
                    ImageListFragment.this.bIy.smoothScrollToPosition(0);
                    ImageListFragment.this.Th();
                }
                ImageListFragment.this.bIy.Tk();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bIC, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bIw, a.c.sdk_cp_cont_b, i);
        if (this.bHF.SG() == 1) {
            SkinManager.setImageResource(this.bIu, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bIv.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bIv, a.c.sdk_ph_navi_back_text_color);
            this.bIu.setVisibility(8);
        }
        if (this.bIw != null) {
            this.bIw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bIz != null) {
            this.bIz.notifyDataSetChanged();
        }
        if (this.bHr != null) {
            df(this.bHr.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bIx != null) {
            this.bIx.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bIs != null) {
            this.bIs.cancelLoadTask();
        }
        if (this.bHF != null) {
            this.bHF.closeLoadingDialog();
        }
        if (this.bID != null) {
            this.bID.setDialogVisiable(false);
        }
        d.Te().b(this);
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
    public void dh(boolean z) {
        SM();
    }

    private void SM() {
        if (!isHidden() && !this.isPaused) {
            SL();
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
            this.bIz.di(true);
        } else if (this.bIz.isScroll()) {
            this.bIz.di(false);
        }
    }

    public void df(boolean z) {
        if (this.bHF != null && this.bHK != null) {
            this.bHK.setText(this.bHF.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_cont_f);
        }
    }
}
