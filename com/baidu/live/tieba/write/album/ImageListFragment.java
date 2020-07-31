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
    private c biP;
    private MediaStoreLoader bjO;
    private RelativeLayout bjP;
    private ImageView bjQ;
    private TextView bjR;
    private TextView bjS;
    private com.baidu.live.tieba.write.a.a bjT;
    private TransparentHeadGridView bjU;
    private i bjV;
    private CommonEmptyView bjW;
    private View bjX;
    private View bjY;
    private boolean bjZ;
    private AlbumActivity bjd;
    private View bjg;
    private TextView bjh;
    private TextView bji;
    private View mView;
    private BlueCircleProgressDialog bka = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.biP != null) {
                if (view == ImageListFragment.this.bjS) {
                    ImageListFragment.this.bjT.b(ImageListFragment.this.biP.IY(), ImageListFragment.this.biP.IW());
                    ImageListFragment.this.bjT.O(ImageListFragment.this.bjX);
                    ImageListFragment.this.bjS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.bjg) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bjS != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bjS.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bjH = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.biP != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.biP.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.bjd.du(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0190a bkb = new a.InterfaceC0190a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0190a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> fM;
            if (ImageListFragment.this.biP != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.biP.IW()) && (fM = ImageListFragment.this.biP.fM(albumId)) != null) {
                    ImageListFragment.this.biP.fK(albumId);
                    ImageListFragment.this.bjV.setData(fM);
                    if (ImageListFragment.this.bjV.getCount() <= 0) {
                        ImageListFragment.this.bjW.setVisibility(0);
                    } else {
                        ImageListFragment.this.bjW.setVisibility(8);
                    }
                    ImageListFragment.this.bjS.setText(name);
                    ImageListFragment.this.bjU.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bjI = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.bjd == null || ImageListFragment.this.biP == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.biP.IS()) {
                    ImageListFragment.this.bjd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.biP.isAdded(imageFileInfo)) {
                    ImageListFragment.this.bjd.b(imageFileInfo);
                } else {
                    ImageListFragment.this.bjd.a(imageFileInfo);
                }
                ImageListFragment.this.biP.a((VideoFileInfo) null);
                ImageListFragment.this.bjV.notifyDataSetChanged();
                ImageListFragment.this.Jd();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.biP.IR()) {
                    ImageListFragment.this.bjd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.biP.b(videoFileInfo)) {
                        ImageListFragment.this.biP.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.biP.a(videoFileInfo);
                    }
                    ImageListFragment.this.biP.IT();
                    ImageListFragment.this.bjV.notifyDataSetChanged();
                    ImageListFragment.this.Jd();
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
        this.bjd = (AlbumActivity) getBaseFragmentActivity();
        this.biP = this.bjd.IC();
        d.Ja().a(this);
        this.bjO = new MediaStoreLoader(this.bjd);
        this.bjT = new com.baidu.live.tieba.write.a.a(this.bjd);
        this.bjT.setOnDismissListener(this.mOnDismissListener);
        this.bjT.a(this.bkb);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bjP = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bjX = this.mView.findViewById(a.g.layout_title);
        this.bjS = (TextView) this.mView.findViewById(a.g.album_title);
        this.bjQ = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bjR = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bjY = this.mView.findViewById(a.g.navi_line);
        this.bjg = this.mView.findViewById(a.g.layout_bottom);
        this.bji = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.bjh = (TextView) this.mView.findViewById(a.g.next_step);
        this.biP.fK(AlbumData.ALBUM_ID_ALL);
        this.bjS.setText(this.bjd.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bjW = new CommonEmptyView(getContext());
        this.bjW.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bjW.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bjW.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bjW.setVisibility(8);
        this.bjW.addToParent(this.bjP);
        this.bjU = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bjU.setSelector(a.d.sdk_transparent);
        this.bjV = new i(this.bjd, this.biP);
        this.bjU.setAdapter((ListAdapter) this.bjV);
        this.bjU.setOuterOnScrollListener(this);
        this.bjV.a(this.bjI);
        this.bjV.a(this.bjH);
        this.bjh.setOnClickListener(this.bjd);
        this.bjQ.setOnClickListener(this.bjd);
        this.bjR.setOnClickListener(this.bjd);
        this.bji.setOnClickListener(this.bjd);
        this.bjS.setOnClickListener(this.mOnClickListener);
        this.bjg.setOnClickListener(this.mOnClickListener);
        Jd();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bka == null) {
            this.bka = new BlueCircleProgressDialog(getPageContext());
        }
        this.bka.setCancelListener(null);
        this.bka.setTipString(a.i.sdk_loading);
        this.bka.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bjd.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jd() {
        int count;
        String string;
        if (this.biP != null && this.bjh != null) {
            if (this.biP.IS()) {
                int i = this.biP.IS() ? 1 : 0;
                count = i;
                string = this.bjd.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.biP.IU());
                string = this.bjd.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.biP.getMaxImagesAllowed())});
            }
            this.bjh.setText(string);
            this.bjh.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bjZ = false;
        if (isShow()) {
            IH();
        }
    }

    private void IG() {
        if (this.biP == null && this.bjd != null) {
            this.biP = this.bjd.IC();
        }
        if (this.biP != null) {
            if (!this.biP.IZ()) {
                this.bjV.notifyDataSetChanged();
            } else {
                Je();
            }
            cp(this.biP.isOriginalImg());
        }
    }

    private void Je() {
        if (this.bjO == null) {
            this.bjO = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bjO.loadAll(this.bjd.IB() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bka != null) {
                    ImageListFragment.this.bka.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.biP != null && resutMediaStore != null) {
                    ImageListFragment.this.biP.a(resutMediaStore);
                    String IW = ImageListFragment.this.biP.IW();
                    ImageListFragment.this.biP.fK(IW);
                    ImageListFragment.this.bjV.setData(ImageListFragment.this.biP.fM(IW));
                    if (ImageListFragment.this.bjV.getCount() <= 0) {
                        ImageListFragment.this.bjW.setVisibility(0);
                    } else {
                        ImageListFragment.this.bjW.setVisibility(8);
                    }
                    ImageListFragment.this.bjU.smoothScrollToPosition(0);
                    ImageListFragment.this.Jd();
                }
                ImageListFragment.this.bjU.Jg();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bjY, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bjS, a.d.sdk_cp_cont_b, i);
        if (this.bjd.IB() == 1) {
            SkinManager.setImageResource(this.bjQ, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bjR.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bjR, a.d.sdk_ph_navi_back_text_color);
            this.bjQ.setVisibility(8);
        }
        if (this.bjS != null) {
            this.bjS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bjV != null) {
            this.bjV.notifyDataSetChanged();
        }
        if (this.biP != null) {
            cp(this.biP.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bjT != null) {
            this.bjT.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bjO != null) {
            this.bjO.cancelLoadTask();
        }
        if (this.bjd != null) {
            this.bjd.closeLoadingDialog();
        }
        if (this.bka != null) {
            this.bka.setDialogVisiable(false);
        }
        d.Ja().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bjZ = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cr(boolean z) {
        IH();
    }

    private void IH() {
        if (!isHidden() && !this.bjZ) {
            IG();
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
            this.bjV.cs(true);
        } else if (this.bjV.isScroll()) {
            this.bjV.cs(false);
        }
    }

    public void cp(boolean z) {
        if (this.bjd != null && this.bji != null) {
            this.bji.setText(this.bjd.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.bji.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bji, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.bji.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bji, a.d.sdk_cp_cont_f);
        }
    }
}
