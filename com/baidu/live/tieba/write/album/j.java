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
/* loaded from: classes4.dex */
public class j implements AbsListView.OnScrollListener, d.a {
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
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bka = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.biP != null) {
                if (view == j.this.bjS) {
                    j.this.bjT.b(j.this.biP.IY(), j.this.biP.IW());
                    j.this.bjT.O(j.this.bjX);
                    j.this.bjS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bjg) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bjS != null) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bjS.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bjH = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.biP != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.biP.d((ImageFileInfo) mediaFileInfo);
                    j.this.bjd.du(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0190a bkb = new a.InterfaceC0190a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0190a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> fM;
            if (j.this.biP != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.biP.IW()) && (fM = j.this.biP.fM(albumId)) != null) {
                    j.this.biP.fK(albumId);
                    j.this.bjV.setData(fM);
                    if (j.this.bjV.getCount() <= 0) {
                        j.this.bjW.setVisibility(0);
                    } else {
                        j.this.bjW.setVisibility(8);
                    }
                    j.this.bjS.setText(name);
                    j.this.bjU.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bjI = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bjd == null || j.this.biP == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.biP.IS()) {
                    j.this.bjd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.biP.isAdded(imageFileInfo)) {
                    j.this.bjd.b(imageFileInfo);
                } else {
                    j.this.bjd.a(imageFileInfo);
                }
                j.this.biP.a((VideoFileInfo) null);
                j.this.bjV.notifyDataSetChanged();
                j.this.Jd();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.biP.IR()) {
                    j.this.bjd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.biP.b(videoFileInfo)) {
                        j.this.biP.a((VideoFileInfo) null);
                    } else {
                        j.this.biP.a(videoFileInfo);
                    }
                    j.this.biP.IT();
                    j.this.bjV.notifyDataSetChanged();
                    j.this.Jd();
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
        this.bjd = albumActivity;
        this.biP = this.bjd.IC();
        d.Ja().a(this);
        this.bjO = new MediaStoreLoader(this.bjd);
        this.bjT = new com.baidu.live.tieba.write.a.a(this.bjd);
        this.bjT.setOnDismissListener(this.mOnDismissListener);
        this.bjT.a(this.bkb);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.bjd).inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
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
        this.bjW = new CommonEmptyView(this.bjd);
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
            this.bka = new BlueCircleProgressDialog(this.tbPageContext);
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

    public void onResume() {
        this.bjZ = false;
        IH();
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
            this.bjO = new MediaStoreLoader(this.bjd);
        }
        this.bjO.loadAll(this.bjd.IB() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bka != null) {
                    j.this.bka.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.biP != null && resutMediaStore != null) {
                    j.this.biP.a(resutMediaStore);
                    String IW = j.this.biP.IW();
                    j.this.biP.fK(IW);
                    j.this.bjV.setData(j.this.biP.fM(IW));
                    if (j.this.bjV.getCount() <= 0) {
                        j.this.bjW.setVisibility(0);
                    } else {
                        j.this.bjW.setVisibility(8);
                    }
                    j.this.bjU.smoothScrollToPosition(0);
                    j.this.Jd();
                }
                j.this.bjU.Jg();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
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

    public View getView() {
        return this.mView;
    }

    public View Jb() {
        return this.bjd.IB() == 1 ? this.bjQ : this.bjR;
    }

    public View Jf() {
        return this.bjh;
    }

    public void onPause() {
        this.bjZ = true;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cr(boolean z) {
        IH();
    }

    private void IH() {
        if (!this.bjZ) {
            IG();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bjV.cs(true);
        } else if (this.bjV.isScroll()) {
            this.bjV.cs(false);
        }
    }

    public void m(int i, boolean z) {
        if (this.bjU != null) {
            int firstVisiblePosition = this.bjU.getFirstVisiblePosition();
            int lastVisiblePosition = this.bjU.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bjU.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bjV != null) {
                    this.bjV.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Jd();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bjV != null) {
            m(this.bjV.e(imageFileInfo), z);
        }
    }

    public View IN() {
        return this.bji;
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
