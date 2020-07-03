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
/* loaded from: classes3.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private AlbumActivity biJ;
    private View biM;
    private TextView biN;
    private TextView biO;
    private c biv;
    private TransparentHeadGridView bjA;
    private i bjB;
    private CommonEmptyView bjC;
    private View bjD;
    private View bjE;
    private boolean bjF;
    private MediaStoreLoader bju;
    private RelativeLayout bjv;
    private ImageView bjw;
    private TextView bjx;
    private TextView bjy;
    private com.baidu.live.tieba.write.a.a bjz;
    private View mView;
    private BlueCircleProgressDialog bjG = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.biv != null) {
                if (view == ImageListFragment.this.bjy) {
                    ImageListFragment.this.bjz.b(ImageListFragment.this.biv.IS(), ImageListFragment.this.biv.IQ());
                    ImageListFragment.this.bjz.L(ImageListFragment.this.bjD);
                    ImageListFragment.this.bjy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == ImageListFragment.this.biM) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.bjy != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.bjy.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bjn = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.biv != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.biv.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.biJ.du(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0188a bjH = new a.InterfaceC0188a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0188a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> fO;
            if (ImageListFragment.this.biv != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.biv.IQ()) && (fO = ImageListFragment.this.biv.fO(albumId)) != null) {
                    ImageListFragment.this.biv.fM(albumId);
                    ImageListFragment.this.bjB.setData(fO);
                    if (ImageListFragment.this.bjB.getCount() <= 0) {
                        ImageListFragment.this.bjC.setVisibility(0);
                    } else {
                        ImageListFragment.this.bjC.setVisibility(8);
                    }
                    ImageListFragment.this.bjy.setText(name);
                    ImageListFragment.this.bjA.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bjo = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.biJ == null || ImageListFragment.this.biv == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.biv.IM()) {
                    ImageListFragment.this.biJ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.biv.isAdded(imageFileInfo)) {
                    ImageListFragment.this.biJ.b(imageFileInfo);
                } else {
                    ImageListFragment.this.biJ.a(imageFileInfo);
                }
                ImageListFragment.this.biv.a((VideoFileInfo) null);
                ImageListFragment.this.bjB.notifyDataSetChanged();
                ImageListFragment.this.IX();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.biv.IL()) {
                    ImageListFragment.this.biJ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.biv.b(videoFileInfo)) {
                        ImageListFragment.this.biv.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.biv.a(videoFileInfo);
                    }
                    ImageListFragment.this.biv.IN();
                    ImageListFragment.this.bjB.notifyDataSetChanged();
                    ImageListFragment.this.IX();
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
        this.biJ = (AlbumActivity) getBaseFragmentActivity();
        this.biv = this.biJ.Iw();
        d.IU().a(this);
        this.bju = new MediaStoreLoader(this.biJ);
        this.bjz = new com.baidu.live.tieba.write.a.a(this.biJ);
        this.bjz.setOnDismissListener(this.mOnDismissListener);
        this.bjz.a(this.bjH);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bjv = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bjD = this.mView.findViewById(a.g.layout_title);
        this.bjy = (TextView) this.mView.findViewById(a.g.album_title);
        this.bjw = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bjx = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bjE = this.mView.findViewById(a.g.navi_line);
        this.biM = this.mView.findViewById(a.g.layout_bottom);
        this.biO = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.biN = (TextView) this.mView.findViewById(a.g.next_step);
        this.biv.fM(AlbumData.ALBUM_ID_ALL);
        this.bjy.setText(this.biJ.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bjC = new CommonEmptyView(getContext());
        this.bjC.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bjC.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bjC.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bjC.setVisibility(8);
        this.bjC.addToParent(this.bjv);
        this.bjA = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bjA.setSelector(a.d.sdk_transparent);
        this.bjB = new i(this.biJ, this.biv);
        this.bjA.setAdapter((ListAdapter) this.bjB);
        this.bjA.setOuterOnScrollListener(this);
        this.bjB.a(this.bjo);
        this.bjB.a(this.bjn);
        this.biN.setOnClickListener(this.biJ);
        this.bjw.setOnClickListener(this.biJ);
        this.bjx.setOnClickListener(this.biJ);
        this.biO.setOnClickListener(this.biJ);
        this.bjy.setOnClickListener(this.mOnClickListener);
        this.biM.setOnClickListener(this.mOnClickListener);
        IX();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bjG == null) {
            this.bjG = new BlueCircleProgressDialog(getPageContext());
        }
        this.bjG.setCancelListener(null);
        this.bjG.setTipString(a.i.sdk_loading);
        this.bjG.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.biJ.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        int count;
        String string;
        if (this.biv != null && this.biN != null) {
            if (this.biv.IM()) {
                int i = this.biv.IM() ? 1 : 0;
                count = i;
                string = this.biJ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.biv.IO());
                string = this.biJ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.biv.getMaxImagesAllowed())});
            }
            this.biN.setText(string);
            this.biN.setEnabled(count > 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bjF = false;
        if (isShow()) {
            IB();
        }
    }

    private void IA() {
        if (this.biv == null && this.biJ != null) {
            this.biv = this.biJ.Iw();
        }
        if (this.biv != null) {
            if (!this.biv.IT()) {
                this.bjB.notifyDataSetChanged();
            } else {
                IY();
            }
            cn(this.biv.isOriginalImg());
        }
    }

    private void IY() {
        if (this.bju == null) {
            this.bju = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.bju.loadAll(this.biJ.Iv() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.bjG != null) {
                    ImageListFragment.this.bjG.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.biv != null && resutMediaStore != null) {
                    ImageListFragment.this.biv.a(resutMediaStore);
                    String IQ = ImageListFragment.this.biv.IQ();
                    ImageListFragment.this.biv.fM(IQ);
                    ImageListFragment.this.bjB.setData(ImageListFragment.this.biv.fO(IQ));
                    if (ImageListFragment.this.bjB.getCount() <= 0) {
                        ImageListFragment.this.bjC.setVisibility(0);
                    } else {
                        ImageListFragment.this.bjC.setVisibility(8);
                    }
                    ImageListFragment.this.bjA.smoothScrollToPosition(0);
                    ImageListFragment.this.IX();
                }
                ImageListFragment.this.bjA.Ja();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.bjE, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bjy, a.d.sdk_cp_cont_b, i);
        if (this.biJ.Iv() == 1) {
            SkinManager.setImageResource(this.bjw, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bjx.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bjx, a.d.sdk_ph_navi_back_text_color);
            this.bjw.setVisibility(8);
        }
        if (this.bjy != null) {
            this.bjy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bjB != null) {
            this.bjB.notifyDataSetChanged();
        }
        if (this.biv != null) {
            cn(this.biv.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.bjz != null) {
            this.bjz.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bju != null) {
            this.bju.cancelLoadTask();
        }
        if (this.biJ != null) {
            this.biJ.closeLoadingDialog();
        }
        if (this.bjG != null) {
            this.bjG.setDialogVisiable(false);
        }
        d.IU().b(this);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bjF = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cp(boolean z) {
        IB();
    }

    private void IB() {
        if (!isHidden() && !this.bjF) {
            IA();
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
            this.bjB.cq(true);
        } else if (this.bjB.isScroll()) {
            this.bjB.cq(false);
        }
    }

    public void cn(boolean z) {
        if (this.biJ != null && this.biO != null) {
            this.biO.setText(this.biJ.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.biO.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.biO, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.biO.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.biO, a.d.sdk_cp_cont_f);
        }
    }
}
