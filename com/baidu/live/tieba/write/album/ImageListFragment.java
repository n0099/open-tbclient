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
import com.baidu.live.r.a;
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
    private c axC;
    private AlbumActivity axQ;
    private View axW;
    private TextView axX;
    private TextView axY;
    private ImageView ayA;
    private TextView ayB;
    private TextView ayC;
    private com.baidu.live.tieba.write.a.a ayD;
    private TransparentHeadGridView ayE;
    private h ayF;
    private CommonEmptyView ayG;
    private View ayH;
    private View ayI;
    private MediaStoreLoader ayy;
    private RelativeLayout ayz;
    private boolean isPaused;
    private View mView;
    private BlueCircleProgressDialog ayJ = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageListFragment.this.axC != null) {
                if (view == ImageListFragment.this.ayC) {
                    ImageListFragment.this.ayD.b(ImageListFragment.this.axC.yr(), ImageListFragment.this.axC.yp());
                    ImageListFragment.this.ayD.R(ImageListFragment.this.ayH);
                    ImageListFragment.this.ayC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                    return;
                }
                if (view == ImageListFragment.this.axW) {
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (ImageListFragment.this.ayC != null && ImageListFragment.this.isAdded()) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ImageListFragment.this.ayC.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f ayr = new f() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && ImageListFragment.this.axC != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    ImageListFragment.this.axC.d((ImageFileInfo) mediaFileInfo);
                    ImageListFragment.this.axQ.cw(1);
                    return;
                }
                if (mediaFileInfo instanceof VideoFileInfo) {
                }
            }
        }
    };
    private a.InterfaceC0095a ayK = new a.InterfaceC0095a() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0095a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> dN;
            if (ImageListFragment.this.axC != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(ImageListFragment.this.axC.yp()) && (dN = ImageListFragment.this.axC.dN(albumId)) != null) {
                    ImageListFragment.this.axC.dL(albumId);
                    ImageListFragment.this.ayF.setData(dN);
                    if (ImageListFragment.this.ayF.getCount() <= 0) {
                        ImageListFragment.this.ayG.setVisibility(0);
                    } else {
                        ImageListFragment.this.ayG.setVisibility(8);
                    }
                    ImageListFragment.this.ayC.setText(name);
                    ImageListFragment.this.ayE.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g ays = new g() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || ImageListFragment.this.axQ == null || ImageListFragment.this.axC == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (ImageListFragment.this.axC.yl()) {
                    ImageListFragment.this.axQ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (ImageListFragment.this.axC.isAdded(imageFileInfo)) {
                    ImageListFragment.this.axQ.b(imageFileInfo);
                } else {
                    ImageListFragment.this.axQ.a(imageFileInfo);
                }
                ImageListFragment.this.axC.a((VideoFileInfo) null);
                ImageListFragment.this.ayF.notifyDataSetChanged();
                ImageListFragment.this.yu();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (ImageListFragment.this.axC.yk()) {
                    ImageListFragment.this.axQ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (ImageListFragment.this.c(videoFileInfo)) {
                    if (ImageListFragment.this.axC.b(videoFileInfo)) {
                        ImageListFragment.this.axC.a((VideoFileInfo) null);
                    } else {
                        ImageListFragment.this.axC.a(videoFileInfo);
                    }
                    ImageListFragment.this.axC.ym();
                    ImageListFragment.this.ayF.notifyDataSetChanged();
                    ImageListFragment.this.yu();
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
        this.axQ = (AlbumActivity) getBaseFragmentActivity();
        this.axC = this.axQ.xV();
        d.yt().a(this);
        this.ayy = new MediaStoreLoader(this.axQ);
        this.ayD = new com.baidu.live.tieba.write.a.a(this.axQ);
        this.ayD.setOnDismissListener(this.mOnDismissListener);
        this.ayD.a(this.ayK);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mView = layoutInflater.inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.ayz = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.ayH = this.mView.findViewById(a.g.layout_title);
        this.ayC = (TextView) this.mView.findViewById(a.g.album_title);
        this.ayA = (ImageView) this.mView.findViewById(a.g.img_close);
        this.ayB = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.ayI = this.mView.findViewById(a.g.navi_line);
        this.axW = this.mView.findViewById(a.g.layout_bottom);
        this.axY = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.axX = (TextView) this.mView.findViewById(a.g.next_step);
        this.axC.dL(AlbumData.ALBUM_ID_ALL);
        this.ayC.setText(this.axQ.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.ayG = new CommonEmptyView(getContext());
        this.ayG.setTitle(a.i.sdk_ph_album_list_no_data);
        this.ayG.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.ayG.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.ayG.setVisibility(8);
        this.ayG.addToParent(this.ayz);
        this.ayE = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.ayE.setSelector(a.d.sdk_transparent);
        this.ayF = new h(this.axQ, this.axC);
        this.ayE.setAdapter((ListAdapter) this.ayF);
        this.ayE.setOuterOnScrollListener(this);
        this.ayF.a(this.ays);
        this.ayF.a(this.ayr);
        this.axX.setOnClickListener(this.axQ);
        this.ayA.setOnClickListener(this.axQ);
        this.ayB.setOnClickListener(this.axQ);
        this.axY.setOnClickListener(this.axQ);
        this.ayC.setOnClickListener(this.mOnClickListener);
        this.axW.setOnClickListener(this.mOnClickListener);
        yu();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.ayJ == null) {
            this.ayJ = new BlueCircleProgressDialog(getPageContext());
        }
        this.ayJ.setCancelListener(null);
        this.ayJ.setTipString(a.i.sdk_loading);
        this.ayJ.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.axQ.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu() {
        int count;
        String string;
        if (this.axC != null && this.axX != null) {
            if (this.axC.yl()) {
                int i = this.axC.yl() ? 1 : 0;
                count = i;
                string = this.axQ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.axC.yn());
                string = this.axQ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.axC.getMaxImagesAllowed())});
            }
            this.axX.setText(string);
            this.axX.setEnabled(count > 0);
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
            yj();
        }
    }

    private void yg() {
        if (this.axC == null && this.axQ != null) {
            this.axC = this.axQ.xV();
        }
        if (this.axC != null) {
            if (!this.axC.ys()) {
                this.ayF.notifyDataSetChanged();
            } else {
                yv();
            }
            bl(this.axC.isOriginalImg());
        }
    }

    private void yv() {
        if (this.ayy == null) {
            this.ayy = new MediaStoreLoader(getPageContext().getPageActivity());
        }
        this.ayy.loadAll(this.axQ.xU() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.ImageListFragment.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (ImageListFragment.this.ayJ != null) {
                    ImageListFragment.this.ayJ.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (ImageListFragment.this.axC != null && resutMediaStore != null) {
                    ImageListFragment.this.axC.a(resutMediaStore);
                    String yp = ImageListFragment.this.axC.yp();
                    ImageListFragment.this.axC.dL(yp);
                    ImageListFragment.this.ayF.setData(ImageListFragment.this.axC.dN(yp));
                    if (ImageListFragment.this.ayF.getCount() <= 0) {
                        ImageListFragment.this.ayG.setVisibility(0);
                    } else {
                        ImageListFragment.this.ayG.setVisibility(8);
                    }
                    ImageListFragment.this.ayE.smoothScrollToPosition(0);
                    ImageListFragment.this.yu();
                }
                ImageListFragment.this.ayE.yx();
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mView);
        SkinManager.setBackgroundColor(this.ayI, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.ayC, a.d.sdk_cp_cont_b, i);
        if (this.axQ.xU() == 1) {
            SkinManager.setImageResource(this.ayA, a.f.sdk_ph_icon_topbar_close_n, i);
            this.ayB.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.ayB, a.d.sdk_ph_navi_back_text_color);
            this.ayA.setVisibility(8);
        }
        if (this.ayC != null) {
            this.ayC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.ayF != null) {
            this.ayF.notifyDataSetChanged();
        }
        if (this.axC != null) {
            bl(this.axC.isOriginalImg());
        }
    }

    public View yh() {
        return this.axQ.xU() == 1 ? this.ayA : this.ayB;
    }

    public View yw() {
        return this.axX;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.ayD != null) {
            this.ayD.clearAnimation();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ayy != null) {
            this.ayy.cancelLoadTask();
        }
        if (this.axQ != null) {
            this.axQ.closeLoadingDialog();
        }
        if (this.ayJ != null) {
            this.ayJ.setDialogVisiable(false);
        }
        d.yt().b(this);
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
    public void bn(boolean z) {
        yj();
    }

    private void yj() {
        if (!isHidden() && !this.isPaused) {
            yg();
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
            this.ayF.bo(true);
        } else if (this.ayF.isScroll()) {
            this.ayF.bo(false);
        }
    }

    public void i(int i, boolean z) {
        if (this.ayE != null) {
            int firstVisiblePosition = this.ayE.getFirstVisiblePosition();
            int lastVisiblePosition = this.ayE.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.ayE.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.ayF != null) {
                    this.ayF.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        yu();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.ayF != null) {
            i(this.ayF.e(imageFileInfo), z);
        }
    }

    public View yd() {
        return this.axY;
    }

    public void bl(boolean z) {
        if (this.axQ != null && this.axY != null) {
            this.axY.setText(this.axQ.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.axY.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.axY, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.axY.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.axY, a.d.sdk_cp_cont_f);
        }
    }
}
