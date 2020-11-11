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
/* loaded from: classes4.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private c bDT;
    private MediaStoreLoader bES;
    private RelativeLayout bET;
    private ImageView bEU;
    private TextView bEV;
    private TextView bEW;
    private com.baidu.live.tieba.write.a.a bEX;
    private TransparentHeadGridView bEY;
    private i bEZ;
    private AlbumActivity bEh;
    private View bEk;
    private TextView bEl;
    private TextView bEm;
    private CommonEmptyView bFa;
    private View bFb;
    private View bFc;
    private boolean bFd;
    private View mView;
    private BlueCircleProgressDialog bFe = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.bDT != null) {
                if (view == ImageListFragment.this.bEW) {
                    ImageListFragment.this.bEX.c(ImageListFragment.this.bDT.Uc(), ImageListFragment.this.bDT.Ua());
                    ImageListFragment.this.bEX.O(ImageListFragment.this.bFb);
                    ImageListFragment.this.bEW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bEk) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bEW != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bEW.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bEL = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.bDT != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.bDT.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bEh.fW(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0220a bFf = new a.InterfaceC0220a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0220a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ix;
            if (ImageListFragment.this.bDT != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.bDT.Ua()) && (ix = ImageListFragment.this.bDT.ix(albumId)) != null) {
                    ImageListFragment.this.bDT.iv(albumId);
                    ImageListFragment.this.bEZ.setData(ix);
                    if (ImageListFragment.this.bEZ.getCount() <= 0) {
                        ImageListFragment.this.bFa.setVisibility(0);
                    } else {
                        ImageListFragment.this.bFa.setVisibility(8);
                    }
                    ImageListFragment.this.bEW.setText(name);
                    ImageListFragment.this.bEY.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bEM = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bEh == null || ImageListFragment.this.bDT == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.bDT.TW()) {
                    ImageListFragment.this.bEh.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.bDT.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bEh.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bEh.a(imageFileInfo);
                }
                ImageListFragment.this.bDT.a((VideoFileInfo) null);
                ImageListFragment.this.bEZ.notifyDataSetChanged();
                ImageListFragment.this.Ug();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.bDT.TV()) {
                    ImageListFragment.this.bEh.showToast(a.h.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.bDT.b(videoFileInfo)) {
                        ImageListFragment.this.bDT.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.bDT.a(videoFileInfo);
                    }
                    ImageListFragment.this.bDT.TX();
                    ImageListFragment.this.bEZ.notifyDataSetChanged();
                    ImageListFragment.this.Ug();
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
        this.bEh = (AlbumActivity) getBaseFragmentActivity();
        this.bDT = this.bEh.TG();
        d.Ud().a(this);
        this.bES = new MediaStoreLoader(this.bEh);
        this.bEX = new com.baidu.live.tieba.write.a.a(this.bEh);
        this.bEX.setOnDismissListener(this.mOnDismissListener);
        this.bEX.a(this.bFf);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.g.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bET = (RelativeLayout) this.mView.findViewById(a.f.album_image_list_root);
        this.bFb = this.mView.findViewById(a.f.layout_title);
        this.bEW = (TextView) this.mView.findViewById(a.f.album_title);
        this.bEU = (ImageView) this.mView.findViewById(a.f.img_close);
        this.bEV = (TextView) this.mView.findViewById(a.f.img_close_text);
        this.bFc = this.mView.findViewById(a.f.navi_line);
        this.bEk = this.mView.findViewById(a.f.layout_bottom);
        this.bEm = (TextView) this.mView.findViewById(a.f.original_select_btn);
        this.bEl = (TextView) this.mView.findViewById(a.f.next_step);
        this.bDT.iv(AlbumData.ALBUM_ID_ALL);
        this.bEW.setText(this.bEh.getPageContext().getString(a.h.sdk_ph_album_all_media));
        this.bFa = new CommonEmptyView(getContext());
        this.bFa.setTitle(a.h.sdk_ph_album_list_no_data);
        this.bFa.setSubTitle(a.h.sdk_ph_album_list_no_data_1);
        this.bFa.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bFa.setVisibility(8);
        this.bFa.addToParent(this.bET);
        this.bEY = (TransparentHeadGridView) this.mView.findViewById(a.f.gv_image_list);
        this.bEY.setSelector(a.c.sdk_transparent);
        this.bEZ = new i(this.bEh, this.bDT);
        this.bEY.setAdapter((ListAdapter) this.bEZ);
        this.bEY.setOuterOnScrollListener(this);
        this.bEZ.a(this.bEM);
        this.bEZ.a(this.bEL);
        this.bEl.setOnClickListener(this.bEh);
        this.bEU.setOnClickListener(this.bEh);
        this.bEV.setOnClickListener(this.bEh);
        this.bEm.setOnClickListener(this.bEh);
        this.bEW.setOnClickListener(this.mOnClickListener);
        this.bEk.setOnClickListener(this.mOnClickListener);
        Ug();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bFe == null) {
            this.bFe = new BlueCircleProgressDialog(getPageContext());
        }
        this.bFe.setCancelListener(null);
        this.bFe.setTipString(a.h.sdk_loading);
        this.bFe.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bEh.showToast(a.h.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ug() {
        int count;
        String string;
        if (this.bDT != null && this.bEl != null) {
            if (this.bDT.TW()) {
                int i = this.bDT.TW() ? 1 : 0;
                count = i;
                string = this.bEh.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bDT.TY());
                string = this.bEh.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bDT.getMaxImagesAllowed())});
            }
            this.bEl.setText(string);
            this.bEl.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bFd = false;
        if (isShow()) {
            TL();
        }
    }

    private void TK() {
        if (this.bDT == null && this.bEh != null) {
            this.bDT = this.bEh.TG();
        }
        if (this.bDT != null) {
            Uh();
            cQ(this.bDT.isOriginalImg());
        }
    }

    private void Uh() {
        if (this.bES == null) {
            this.bES = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bES.loadAll(this.bEh.TF() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bFe != null) {
                    ImageListFragment.this.bFe.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.bDT != null && resutMediaStore != null) {
                    ImageListFragment.this.bDT.a(resutMediaStore);
                    String Ua = ImageListFragment.this.bDT.Ua();
                    ImageListFragment.this.bDT.iv(Ua);
                    ImageListFragment.this.bEZ.setData(ImageListFragment.this.bDT.ix(Ua));
                    if (ImageListFragment.this.bEZ.getCount() <= 0) {
                        ImageListFragment.this.bFa.setVisibility(0);
                    } else {
                        ImageListFragment.this.bFa.setVisibility(8);
                    }
                    ImageListFragment.this.bEY.smoothScrollToPosition(0);
                    ImageListFragment.this.Ug();
                }
                ImageListFragment.this.bEY.Uj();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bFc, a.c.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bEW, a.c.sdk_cp_cont_b, i);
        if (this.bEh.TF() == 1) {
            SkinManager.setImageResource(this.bEU, a.e.sdk_ph_icon_topbar_close_n, i);
            this.bEV.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bEV, a.c.sdk_ph_navi_back_text_color);
            this.bEU.setVisibility(8);
        }
        if (this.bEW != null) {
            this.bEW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.e.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bEZ != null) {
            this.bEZ.notifyDataSetChanged();
        }
        if (this.bDT != null) {
            cQ(this.bDT.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bEX != null) {
            this.bEX.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bES != null) {
            this.bES.cancelLoadTask();
        }
        if (this.bEh != null) {
            this.bEh.closeLoadingDialog();
        }
        if (this.bFe != null) {
            this.bFe.setDialogVisiable(false);
        }
        d.Ud().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bFd = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cS(boolean z) {
        TL();
    }

    private void TL() {
        if (!isHidden() && !this.bFd) {
            TK();
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
            this.bEZ.cT(true);
        } else if (this.bEZ.isScroll()) {
            this.bEZ.cT(false);
        }
    }

    public void cQ(boolean z) {
        if (this.bEh != null && this.bEm != null) {
            this.bEm.setText(this.bEh.getResources().getString(a.h.sdk_ph_original_img));
            if (z) {
                this.bEm.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bEm, a.c.sdk_cp_link_tip_a);
                return;
            }
            this.bEm.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bEm, a.c.sdk_cp_cont_f);
        }
    }
}
