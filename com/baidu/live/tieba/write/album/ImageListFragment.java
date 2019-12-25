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
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class ImageListFragment extends BaseFragment implements AbsListView.OnScrollListener, d.a {
    private c awT;
    private MediaStoreLoader axP;
    private RelativeLayout axQ;
    private ImageView axR;
    private TextView axS;
    private TextView axT;
    private com.baidu.live.tieba.write.a.a axU;
    private TransparentHeadGridView axV;
    private h axW;
    private CommonEmptyView axX;
    private View axY;
    private View axZ;
    private AlbumActivity axh;
    private View axn;
    private TextView axo;
    private TextView axp;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog aya = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.awT != null) {
                if (view == ImageListFragment.this.axT) {
                    ImageListFragment.this.axU.b(ImageListFragment.this.awT.yb(), ImageListFragment.this.awT.xZ());
                    ImageListFragment.this.axU.P(ImageListFragment.this.axY);
                    ImageListFragment.this.axT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                    return;
                }
                if (view == ImageListFragment.this.axn) {
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.axT != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.axT.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f axI = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.awT != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.awT.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.axh.cv(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0094a ayb = new a.InterfaceC0094a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0094a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> dL;
            if (ImageListFragment.this.awT != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.awT.xZ()) && (dL = ImageListFragment.this.awT.dL(albumId)) != null) {
                    ImageListFragment.this.awT.dJ(albumId);
                    ImageListFragment.this.axW.setData(dL);
                    if (ImageListFragment.this.axW.getCount() <= 0) {
                        ImageListFragment.this.axX.setVisibility(0);
                    } else {
                        ImageListFragment.this.axX.setVisibility(8);
                    }
                    ImageListFragment.this.axT.setText(name);
                    ImageListFragment.this.axV.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g axJ = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.axh == null || ImageListFragment.this.awT == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.awT.xV()) {
                    ImageListFragment.this.axh.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.awT.isAdded(imageFileInfo)) {
                    ImageListFragment.this.axh.b(imageFileInfo);
                } else {
                    ImageListFragment.this.axh.a(imageFileInfo);
                }
                ImageListFragment.this.awT.a((VideoFileInfo) null);
                ImageListFragment.this.axW.notifyDataSetChanged();
                ImageListFragment.this.ye();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.awT.xU()) {
                    ImageListFragment.this.axh.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.awT.b(videoFileInfo)) {
                        ImageListFragment.this.awT.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.awT.a(videoFileInfo);
                    }
                    ImageListFragment.this.awT.xW();
                    ImageListFragment.this.axW.notifyDataSetChanged();
                    ImageListFragment.this.ye();
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
        this.axh = (AlbumActivity) getBaseFragmentActivity();
        this.awT = this.axh.xF();
        d.yd().a(this);
        this.axP = new MediaStoreLoader(this.axh);
        this.axU = new com.baidu.live.tieba.write.a.a(this.axh);
        this.axU.setOnDismissListener(this.mOnDismissListener);
        this.axU.a(this.ayb);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.axQ = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.axY = this.mView.findViewById(a.g.layout_title);
        this.axT = (TextView) this.mView.findViewById(a.g.album_title);
        this.axR = (ImageView) this.mView.findViewById(a.g.img_close);
        this.axS = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.axZ = this.mView.findViewById(a.g.navi_line);
        this.axn = this.mView.findViewById(a.g.layout_bottom);
        this.axp = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.axo = (TextView) this.mView.findViewById(a.g.next_step);
        this.awT.dJ(AlbumData.ALBUM_ID_ALL);
        this.axT.setText(this.axh.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.axX = new CommonEmptyView(getContext());
        this.axX.setTitle(a.i.sdk_ph_album_list_no_data);
        this.axX.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.axX.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.axX.setVisibility(8);
        this.axX.addToParent(this.axQ);
        this.axV = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.axV.setSelector(a.d.sdk_transparent);
        this.axW = new h(this.axh, this.awT);
        this.axV.setAdapter((ListAdapter) this.axW);
        this.axV.setOuterOnScrollListener(this);
        this.axW.a(this.axJ);
        this.axW.a(this.axI);
        this.axo.setOnClickListener(this.axh);
        this.axR.setOnClickListener(this.axh);
        this.axS.setOnClickListener(this.axh);
        this.axp.setOnClickListener(this.axh);
        this.axT.setOnClickListener(this.mOnClickListener);
        this.axn.setOnClickListener(this.mOnClickListener);
        ye();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.aya == null) {
            this.aya = new BlueCircleProgressDialog(getPageContext());
        }
        this.aya.setCancelListener(null);
        this.aya.setTipString(a.i.sdk_loading);
        this.aya.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.axh.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye() {
        int count;
        String string;
        if (this.awT != null && this.axo != null) {
            if (this.awT.xV()) {
                int i = this.awT.xV() ? 1 : 0;
                count = i;
                string = this.axh.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.awT.xX());
                string = this.axh.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.awT.getMaxImagesAllowed())});
            }
            this.axo.setText(string);
            this.axo.setEnabled(count > 0);
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
            xT();
        }
    }

    private void xQ() {
        if (this.awT == null && this.axh != null) {
            this.awT = this.axh.xF();
        }
        if (this.awT != null) {
            if (!this.awT.yc()) {
                this.axW.notifyDataSetChanged();
            } else {
                yf();
            }
            bh(this.awT.isOriginalImg());
        }
    }

    private void yf() {
        if (this.axP == null) {
            this.axP = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.axP.loadAll(this.axh.xE() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.aya != null) {
                    ImageListFragment.this.aya.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.awT != null && resutMediaStore != null) {
                    ImageListFragment.this.awT.a(resutMediaStore);
                    String xZ = ImageListFragment.this.awT.xZ();
                    ImageListFragment.this.awT.dJ(xZ);
                    ImageListFragment.this.axW.setData(ImageListFragment.this.awT.dL(xZ));
                    if (ImageListFragment.this.axW.getCount() <= 0) {
                        ImageListFragment.this.axX.setVisibility(0);
                    } else {
                        ImageListFragment.this.axX.setVisibility(8);
                    }
                    ImageListFragment.this.axV.smoothScrollToPosition(0);
                    ImageListFragment.this.ye();
                }
                ImageListFragment.this.axV.yh();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.axZ, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.axT, a.d.sdk_cp_cont_b, i);
        if (this.axh.xE() == 1) {
            SkinManager.setImageResource(this.axR, a.f.sdk_ph_icon_topbar_close_n, i);
            this.axS.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.axS, a.d.sdk_ph_navi_back_text_color);
            this.axR.setVisibility(8);
        }
        if (this.axT != null) {
            this.axT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.axW != null) {
            this.axW.notifyDataSetChanged();
        }
        if (this.awT != null) {
            bh(this.awT.isOriginalImg());
        }
    }

    public View xR() {
        return this.axh.xE() == 1 ? this.axR : this.axS;
    }

    public View yg() {
        return this.axo;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.axU != null) {
            this.axU.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.axP != null) {
            this.axP.cancelLoadTask();
        }
        if (this.axh != null) {
            this.axh.closeLoadingDialog();
        }
        if (this.aya != null) {
            this.aya.setDialogVisiable(false);
        }
        d.yd().b(this);
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
    public void bj(boolean z) {
        xT();
    }

    private void xT() {
        if (!isHidden() && !this.isPaused) {
            xQ();
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
            this.axW.bk(true);
        } else if (this.axW.isScroll()) {
            this.axW.bk(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.axV != null) {
            int firstVisiblePosition = this.axV.getFirstVisiblePosition();
            int lastVisiblePosition = this.axV.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.axV.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.axW != null) {
                    this.axW.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        ye();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.axW != null) {
            i(this.axW.e(imageFileInfo), z);
        }
    }

    public View xN() {
        return this.axp;
    }

    public void bh(boolean z) {
        if (this.axh != null && this.axp != null) {
            this.axp.setText(this.axh.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.axp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.axp, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.axp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.axp, a.d.sdk_cp_cont_f);
        }
    }
}
