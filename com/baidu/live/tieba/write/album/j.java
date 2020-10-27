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
    private c bxI;
    private AlbumActivity bxW;
    private View bxZ;
    private MediaStoreLoader byH;
    private RelativeLayout byI;
    private ImageView byJ;
    private TextView byK;
    private TextView byL;
    private com.baidu.live.tieba.write.a.a byM;
    private TransparentHeadGridView byN;
    private i byO;
    private CommonEmptyView byP;
    private View byQ;
    private View byR;
    private boolean byS;
    private TextView bya;
    private TextView byb;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog byT = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bxI != null) {
                if (view == j.this.byL) {
                    j.this.byM.c(j.this.bxI.Ru(), j.this.bxI.Rs());
                    j.this.byM.O(j.this.byQ);
                    j.this.byL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bxZ) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.byL != null) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.byL.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f byA = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bxI != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bxI.d((ImageFileInfo) mediaFileInfo);
                    j.this.bxW.fJ(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0208a byU = new a.InterfaceC0208a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0208a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> ie;
            if (j.this.bxI != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bxI.Rs()) && (ie = j.this.bxI.ie(albumId)) != null) {
                    j.this.bxI.ic(albumId);
                    j.this.byO.setData(ie);
                    if (j.this.byO.getCount() <= 0) {
                        j.this.byP.setVisibility(0);
                    } else {
                        j.this.byP.setVisibility(8);
                    }
                    j.this.byL.setText(name);
                    j.this.byN.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g byB = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bxW == null || j.this.bxI == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bxI.Ro()) {
                    j.this.bxW.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bxI.isAdded(imageFileInfo)) {
                    j.this.bxW.b(imageFileInfo);
                } else {
                    j.this.bxW.a(imageFileInfo);
                }
                j.this.bxI.a((VideoFileInfo) null);
                j.this.byO.notifyDataSetChanged();
                j.this.Ry();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bxI.Rn()) {
                    j.this.bxW.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bxI.b(videoFileInfo)) {
                        j.this.bxI.a((VideoFileInfo) null);
                    } else {
                        j.this.bxI.a(videoFileInfo);
                    }
                    j.this.bxI.Rp();
                    j.this.byO.notifyDataSetChanged();
                    j.this.Ry();
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
        this.bxW = albumActivity;
        this.bxI = this.bxW.QY();
        d.Rv().a(this);
        this.byH = new MediaStoreLoader(this.bxW);
        this.byM = new com.baidu.live.tieba.write.a.a(this.bxW);
        this.byM.setOnDismissListener(this.mOnDismissListener);
        this.byM.a(this.byU);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.bxW).inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.byI = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.byQ = this.mView.findViewById(a.g.layout_title);
        this.byL = (TextView) this.mView.findViewById(a.g.album_title);
        this.byJ = (ImageView) this.mView.findViewById(a.g.img_close);
        this.byK = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.byR = this.mView.findViewById(a.g.navi_line);
        this.bxZ = this.mView.findViewById(a.g.layout_bottom);
        this.byb = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.bya = (TextView) this.mView.findViewById(a.g.next_step);
        this.bxI.ic(AlbumData.ALBUM_ID_ALL);
        this.byL.setText(this.bxW.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.byP = new CommonEmptyView(this.bxW);
        this.byP.setTitle(a.i.sdk_ph_album_list_no_data);
        this.byP.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.byP.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.byP.setVisibility(8);
        this.byP.addToParent(this.byI);
        this.byN = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.byN.setSelector(a.d.sdk_transparent);
        this.byO = new i(this.bxW, this.bxI);
        this.byN.setAdapter((ListAdapter) this.byO);
        this.byN.setOuterOnScrollListener(this);
        this.byO.a(this.byB);
        this.byO.a(this.byA);
        this.bya.setOnClickListener(this.bxW);
        this.byJ.setOnClickListener(this.bxW);
        this.byK.setOnClickListener(this.bxW);
        this.byb.setOnClickListener(this.bxW);
        this.byL.setOnClickListener(this.mOnClickListener);
        this.bxZ.setOnClickListener(this.mOnClickListener);
        Ry();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.byT == null) {
            this.byT = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.byT.setCancelListener(null);
        this.byT.setTipString(a.i.sdk_loading);
        this.byT.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bxW.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry() {
        int count;
        String string;
        if (this.bxI != null && this.bya != null) {
            if (this.bxI.Ro()) {
                int i = this.bxI.Ro() ? 1 : 0;
                count = i;
                string = this.bxW.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bxI.Rq());
                string = this.bxW.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bxI.getMaxImagesAllowed())});
            }
            this.bya.setText(string);
            this.bya.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.byS = false;
        Rd();
    }

    private void Rc() {
        if (this.bxI == null && this.bxW != null) {
            this.bxI = this.bxW.QY();
        }
        if (this.bxI != null) {
            Rz();
            cJ(this.bxI.isOriginalImg());
        }
    }

    private void Rz() {
        if (this.byH == null) {
            this.byH = new MediaStoreLoader(this.bxW);
        }
        this.byH.loadAll(this.bxW.QX() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.byT != null) {
                    j.this.byT.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bxI != null && resutMediaStore != null) {
                    j.this.bxI.a(resutMediaStore);
                    String Rs = j.this.bxI.Rs();
                    j.this.bxI.ic(Rs);
                    j.this.byO.setData(j.this.bxI.ie(Rs));
                    if (j.this.byO.getCount() <= 0) {
                        j.this.byP.setVisibility(0);
                    } else {
                        j.this.byP.setVisibility(8);
                    }
                    j.this.byN.smoothScrollToPosition(0);
                    j.this.Ry();
                }
                j.this.byN.RB();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.byR, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.byL, a.d.sdk_cp_cont_b, i);
        if (this.bxW.QX() == 1) {
            SkinManager.setImageResource(this.byJ, a.f.sdk_ph_icon_topbar_close_n, i);
            this.byK.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.byK, a.d.sdk_ph_navi_back_text_color);
            this.byJ.setVisibility(8);
        }
        if (this.byL != null) {
            this.byL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.byO != null) {
            this.byO.notifyDataSetChanged();
        }
        if (this.bxI != null) {
            cJ(this.bxI.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View Rw() {
        return this.bxW.QX() == 1 ? this.byJ : this.byK;
    }

    public View RA() {
        return this.bya;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cL(boolean z) {
        Rd();
    }

    private void Rd() {
        if (!this.byS) {
            Rc();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.byO.cM(true);
        } else if (this.byO.isScroll()) {
            this.byO.cM(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.byN != null) {
            int firstVisiblePosition = this.byN.getFirstVisiblePosition();
            int lastVisiblePosition = this.byN.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.byN.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.byO != null) {
                    this.byO.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Ry();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.byO != null) {
            o(this.byO.e(imageFileInfo), z);
        }
    }

    public View Rj() {
        return this.byb;
    }

    public void cJ(boolean z) {
        if (this.bxW != null && this.byb != null) {
            this.byb.setText(this.bxW.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.byb.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.byb, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.byb.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.byb, a.d.sdk_cp_cont_f);
        }
    }
}
