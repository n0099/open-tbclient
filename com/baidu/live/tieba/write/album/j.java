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
    private c brG;
    private AlbumActivity brU;
    private View brX;
    private TextView brY;
    private TextView brZ;
    private MediaStoreLoader bsF;
    private RelativeLayout bsG;
    private ImageView bsH;
    private TextView bsI;
    private TextView bsJ;
    private com.baidu.live.tieba.write.a.a bsK;
    private TransparentHeadGridView bsL;
    private i bsM;
    private CommonEmptyView bsN;
    private View bsO;
    private View bsP;
    private boolean bsQ;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bsR = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.brG != null) {
                if (view == j.this.bsJ) {
                    j.this.bsK.b(j.this.brG.Pu(), j.this.brG.Ps());
                    j.this.bsK.O(j.this.bsO);
                    j.this.bsJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.brX) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bsJ != null) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bsJ.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bsy = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.brG != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.brG.d((ImageFileInfo) mediaFileInfo);
                    j.this.brU.fy(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0197a bsS = new a.InterfaceC0197a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0197a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hx;
            if (j.this.brG != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.brG.Ps()) && (hx = j.this.brG.hx(albumId)) != null) {
                    j.this.brG.hv(albumId);
                    j.this.bsM.setData(hx);
                    if (j.this.bsM.getCount() <= 0) {
                        j.this.bsN.setVisibility(0);
                    } else {
                        j.this.bsN.setVisibility(8);
                    }
                    j.this.bsJ.setText(name);
                    j.this.bsL.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bsz = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.brU == null || j.this.brG == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.brG.Po()) {
                    j.this.brU.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.brG.isAdded(imageFileInfo)) {
                    j.this.brU.b(imageFileInfo);
                } else {
                    j.this.brU.a(imageFileInfo);
                }
                j.this.brG.a((VideoFileInfo) null);
                j.this.bsM.notifyDataSetChanged();
                j.this.Py();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.brG.Pn()) {
                    j.this.brU.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.brG.b(videoFileInfo)) {
                        j.this.brG.a((VideoFileInfo) null);
                    } else {
                        j.this.brG.a(videoFileInfo);
                    }
                    j.this.brG.Pp();
                    j.this.bsM.notifyDataSetChanged();
                    j.this.Py();
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
        this.brU = albumActivity;
        this.brG = this.brU.OY();
        d.Pv().a(this);
        this.bsF = new MediaStoreLoader(this.brU);
        this.bsK = new com.baidu.live.tieba.write.a.a(this.brU);
        this.bsK.setOnDismissListener(this.mOnDismissListener);
        this.bsK.a(this.bsS);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.brU).inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bsG = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bsO = this.mView.findViewById(a.g.layout_title);
        this.bsJ = (TextView) this.mView.findViewById(a.g.album_title);
        this.bsH = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bsI = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bsP = this.mView.findViewById(a.g.navi_line);
        this.brX = this.mView.findViewById(a.g.layout_bottom);
        this.brZ = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.brY = (TextView) this.mView.findViewById(a.g.next_step);
        this.brG.hv(AlbumData.ALBUM_ID_ALL);
        this.bsJ.setText(this.brU.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bsN = new CommonEmptyView(this.brU);
        this.bsN.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bsN.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bsN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bsN.setVisibility(8);
        this.bsN.addToParent(this.bsG);
        this.bsL = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bsL.setSelector(a.d.sdk_transparent);
        this.bsM = new i(this.brU, this.brG);
        this.bsL.setAdapter((ListAdapter) this.bsM);
        this.bsL.setOuterOnScrollListener(this);
        this.bsM.a(this.bsz);
        this.bsM.a(this.bsy);
        this.brY.setOnClickListener(this.brU);
        this.bsH.setOnClickListener(this.brU);
        this.bsI.setOnClickListener(this.brU);
        this.brZ.setOnClickListener(this.brU);
        this.bsJ.setOnClickListener(this.mOnClickListener);
        this.brX.setOnClickListener(this.mOnClickListener);
        Py();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bsR == null) {
            this.bsR = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bsR.setCancelListener(null);
        this.bsR.setTipString(a.i.sdk_loading);
        this.bsR.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.brU.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py() {
        int count;
        String string;
        if (this.brG != null && this.brY != null) {
            if (this.brG.Po()) {
                int i = this.brG.Po() ? 1 : 0;
                count = i;
                string = this.brU.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.brG.Pq());
                string = this.brU.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.brG.getMaxImagesAllowed())});
            }
            this.brY.setText(string);
            this.brY.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.bsQ = false;
        Pd();
    }

    private void Pc() {
        if (this.brG == null && this.brU != null) {
            this.brG = this.brU.OY();
        }
        if (this.brG != null) {
            Pz();
            cA(this.brG.isOriginalImg());
        }
    }

    private void Pz() {
        if (this.bsF == null) {
            this.bsF = new MediaStoreLoader(this.brU);
        }
        this.bsF.loadAll(this.brU.OX() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bsR != null) {
                    j.this.bsR.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.brG != null && resutMediaStore != null) {
                    j.this.brG.a(resutMediaStore);
                    String Ps = j.this.brG.Ps();
                    j.this.brG.hv(Ps);
                    j.this.bsM.setData(j.this.brG.hx(Ps));
                    if (j.this.bsM.getCount() <= 0) {
                        j.this.bsN.setVisibility(0);
                    } else {
                        j.this.bsN.setVisibility(8);
                    }
                    j.this.bsL.smoothScrollToPosition(0);
                    j.this.Py();
                }
                j.this.bsL.PB();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bsP, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bsJ, a.d.sdk_cp_cont_b, i);
        if (this.brU.OX() == 1) {
            SkinManager.setImageResource(this.bsH, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bsI.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bsI, a.d.sdk_ph_navi_back_text_color);
            this.bsH.setVisibility(8);
        }
        if (this.bsJ != null) {
            this.bsJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bsM != null) {
            this.bsM.notifyDataSetChanged();
        }
        if (this.brG != null) {
            cA(this.brG.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View Pw() {
        return this.brU.OX() == 1 ? this.bsH : this.bsI;
    }

    public View PA() {
        return this.brY;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cC(boolean z) {
        Pd();
    }

    private void Pd() {
        if (!this.bsQ) {
            Pc();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bsM.cD(true);
        } else if (this.bsM.isScroll()) {
            this.bsM.cD(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bsL != null) {
            int firstVisiblePosition = this.bsL.getFirstVisiblePosition();
            int lastVisiblePosition = this.bsL.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bsL.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bsM != null) {
                    this.bsM.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Py();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bsM != null) {
            o(this.bsM.e(imageFileInfo), z);
        }
    }

    public View Pj() {
        return this.brZ;
    }

    public void cA(boolean z) {
        if (this.brU != null && this.brZ != null) {
            this.brZ.setText(this.brU.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.brZ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.brZ, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.brZ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.brZ, a.d.sdk_cp_cont_f);
        }
    }
}
