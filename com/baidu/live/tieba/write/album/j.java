package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.MediaStoreLoadCallback;
import com.baidu.live.tbadk.album.MediaStoreLoader;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
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
public class j implements AbsListView.OnScrollListener, d.a {
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
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bjG = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.biv != null) {
                if (view == j.this.bjy) {
                    j.this.bjz.b(j.this.biv.IS(), j.this.biv.IQ());
                    j.this.bjz.L(j.this.bjD);
                    j.this.bjy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.biM) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bjy != null) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bjy.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bjn = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.biv != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.biv.d((ImageFileInfo) mediaFileInfo);
                    j.this.biJ.du(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0188a bjH = new a.InterfaceC0188a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0188a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> fO;
            if (j.this.biv != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.biv.IQ()) && (fO = j.this.biv.fO(albumId)) != null) {
                    j.this.biv.fM(albumId);
                    j.this.bjB.setData(fO);
                    if (j.this.bjB.getCount() <= 0) {
                        j.this.bjC.setVisibility(0);
                    } else {
                        j.this.bjC.setVisibility(8);
                    }
                    j.this.bjy.setText(name);
                    j.this.bjA.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bjo = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.biJ == null || j.this.biv == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.biv.IM()) {
                    j.this.biJ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.biv.isAdded(imageFileInfo)) {
                    j.this.biJ.b(imageFileInfo);
                } else {
                    j.this.biJ.a(imageFileInfo);
                }
                j.this.biv.a((VideoFileInfo) null);
                j.this.bjB.notifyDataSetChanged();
                j.this.IX();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.biv.IL()) {
                    j.this.biJ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.biv.b(videoFileInfo)) {
                        j.this.biv.a((VideoFileInfo) null);
                    } else {
                        j.this.biv.a(videoFileInfo);
                    }
                    j.this.biv.IN();
                    j.this.bjB.notifyDataSetChanged();
                    j.this.IX();
                    return true;
                }
                return true;
            } else {
                return false;
            }
        }
    };

    public j(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.biJ = albumActivity;
        this.biv = this.biJ.Iw();
        d.IU().a(this);
        this.bju = new MediaStoreLoader(this.biJ);
        this.bjz = new com.baidu.live.tieba.write.a.a(this.biJ);
        this.bjz.setOnDismissListener(this.mOnDismissListener);
        this.bjz.a(this.bjH);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.biJ).inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
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
        this.bjC = new CommonEmptyView(this.biJ);
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
            this.bjG = new BlueCircleProgressDialog(this.tbPageContext);
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

    public void onResume() {
        this.bjF = false;
        IB();
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
            this.bju = new MediaStoreLoader(this.biJ);
        }
        this.bju.loadAll(this.biJ.Iv() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bjG != null) {
                    j.this.bjG.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.biv != null && resutMediaStore != null) {
                    j.this.biv.a(resutMediaStore);
                    String IQ = j.this.biv.IQ();
                    j.this.biv.fM(IQ);
                    j.this.bjB.setData(j.this.biv.fO(IQ));
                    if (j.this.bjB.getCount() <= 0) {
                        j.this.bjC.setVisibility(0);
                    } else {
                        j.this.bjC.setVisibility(8);
                    }
                    j.this.bjA.smoothScrollToPosition(0);
                    j.this.IX();
                }
                j.this.bjA.Ja();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
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

    public View getView() {
        return this.mView;
    }

    public View IV() {
        return this.biJ.Iv() == 1 ? this.bjw : this.bjx;
    }

    public View IZ() {
        return this.biN;
    }

    public void onPause() {
        this.bjF = true;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cp(boolean z) {
        IB();
    }

    private void IB() {
        if (!this.bjF) {
            IA();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bjB.cq(true);
        } else if (this.bjB.isScroll()) {
            this.bjB.cq(false);
        }
    }

    public void m(int i, boolean z) {
        if (this.bjA != null) {
            int firstVisiblePosition = this.bjA.getFirstVisiblePosition();
            int lastVisiblePosition = this.bjA.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bjA.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bjB != null) {
                    this.bjB.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        IX();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bjB != null) {
            m(this.bjB.e(imageFileInfo), z);
        }
    }

    public View IH() {
        return this.biO;
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
