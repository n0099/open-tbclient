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
    private AlbumActivity bvI;
    private View bvL;
    private TextView bvM;
    private TextView bvN;
    private c bvu;
    private i bwA;
    private CommonEmptyView bwB;
    private View bwC;
    private View bwD;
    private boolean bwE;
    private MediaStoreLoader bwt;
    private RelativeLayout bwu;
    private ImageView bwv;
    private TextView bww;
    private TextView bwx;
    private com.baidu.live.tieba.write.a.a bwy;
    private TransparentHeadGridView bwz;
    private View mView;
    private TbPageContext tbPageContext;
    private BlueCircleProgressDialog bwF = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.bvu != null) {
                if (view == j.this.bwx) {
                    j.this.bwy.b(j.this.bvu.Qz(), j.this.bvu.Qx());
                    j.this.bwy.O(j.this.bwC);
                    j.this.bwx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_retract), (Drawable) null);
                } else if (view == j.this.bvL) {
                    Log.d("onClick", "mLayoutBottom");
                }
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.live.tieba.write.album.j.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (j.this.bwx != null) {
                Drawable drawable = SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                j.this.bwx.setCompoundDrawables(null, null, drawable, null);
            }
        }
    };
    private f bwm = new f() { // from class: com.baidu.live.tieba.write.album.j.3
        @Override // com.baidu.live.tieba.write.album.f
        public void a(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo != null && j.this.bvu != null) {
                if (mediaFileInfo instanceof ImageFileInfo) {
                    j.this.bvu.d((ImageFileInfo) mediaFileInfo);
                    j.this.bvI.fH(1);
                } else if (mediaFileInfo instanceof VideoFileInfo) {
                    Log.d("onClick", "VideoFileInfo");
                }
            }
        }
    };
    private a.InterfaceC0205a bwG = new a.InterfaceC0205a() { // from class: com.baidu.live.tieba.write.album.j.4
        @Override // com.baidu.live.tieba.write.a.a.InterfaceC0205a
        public void a(int i, AlbumData albumData) {
            List<MediaFileInfo> hO;
            if (j.this.bvu != null && albumData != null) {
                String albumId = albumData.getAlbumId();
                String name = albumData.getName();
                if (albumId != null && !albumId.equals(j.this.bvu.Qx()) && (hO = j.this.bvu.hO(albumId)) != null) {
                    j.this.bvu.hM(albumId);
                    j.this.bwA.setData(hO);
                    if (j.this.bwA.getCount() <= 0) {
                        j.this.bwB.setVisibility(0);
                    } else {
                        j.this.bwB.setVisibility(8);
                    }
                    j.this.bwx.setText(name);
                    j.this.bwz.smoothScrollToPosition(0);
                }
            }
        }
    };
    private g bwn = new g() { // from class: com.baidu.live.tieba.write.album.j.5
        @Override // com.baidu.live.tieba.write.album.g
        public boolean b(int i, MediaFileInfo mediaFileInfo) {
            if (mediaFileInfo == null || j.this.bvI == null || j.this.bvu == null) {
                return true;
            }
            if (mediaFileInfo instanceof ImageFileInfo) {
                if (j.this.bvu.Qt()) {
                    j.this.bvI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (j.this.bvu.isAdded(imageFileInfo)) {
                    j.this.bvI.b(imageFileInfo);
                } else {
                    j.this.bvI.a(imageFileInfo);
                }
                j.this.bvu.a((VideoFileInfo) null);
                j.this.bwA.notifyDataSetChanged();
                j.this.QD();
                return true;
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                if (j.this.bvu.Qs()) {
                    j.this.bvI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                    return true;
                }
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (j.this.c(videoFileInfo)) {
                    if (j.this.bvu.b(videoFileInfo)) {
                        j.this.bvu.a((VideoFileInfo) null);
                    } else {
                        j.this.bvu.a(videoFileInfo);
                    }
                    j.this.bvu.Qu();
                    j.this.bwA.notifyDataSetChanged();
                    j.this.QD();
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
        this.bvI = albumActivity;
        this.bvu = this.bvI.Qd();
        d.QA().a(this);
        this.bwt = new MediaStoreLoader(this.bvI);
        this.bwy = new com.baidu.live.tieba.write.a.a(this.bvI);
        this.bwy.setOnDismissListener(this.mOnDismissListener);
        this.bwy.a(this.bwG);
        initView();
    }

    public View initView() {
        this.mView = LayoutInflater.from(this.bvI).inflate(a.h.sdk_ph_album_image_list_view, (ViewGroup) null);
        this.bwu = (RelativeLayout) this.mView.findViewById(a.g.album_image_list_root);
        this.bwC = this.mView.findViewById(a.g.layout_title);
        this.bwx = (TextView) this.mView.findViewById(a.g.album_title);
        this.bwv = (ImageView) this.mView.findViewById(a.g.img_close);
        this.bww = (TextView) this.mView.findViewById(a.g.img_close_text);
        this.bwD = this.mView.findViewById(a.g.navi_line);
        this.bvL = this.mView.findViewById(a.g.layout_bottom);
        this.bvN = (TextView) this.mView.findViewById(a.g.original_select_btn);
        this.bvM = (TextView) this.mView.findViewById(a.g.next_step);
        this.bvu.hM(AlbumData.ALBUM_ID_ALL);
        this.bwx.setText(this.bvI.getPageContext().getString(a.i.sdk_ph_album_all_media));
        this.bwB = new CommonEmptyView(this.bvI);
        this.bwB.setTitle(a.i.sdk_ph_album_list_no_data);
        this.bwB.setSubTitle(a.i.sdk_ph_album_list_no_data_1);
        this.bwB.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bwB.setVisibility(8);
        this.bwB.addToParent(this.bwu);
        this.bwz = (TransparentHeadGridView) this.mView.findViewById(a.g.gv_image_list);
        this.bwz.setSelector(a.d.sdk_transparent);
        this.bwA = new i(this.bvI, this.bvu);
        this.bwz.setAdapter((ListAdapter) this.bwA);
        this.bwz.setOuterOnScrollListener(this);
        this.bwA.a(this.bwn);
        this.bwA.a(this.bwm);
        this.bvM.setOnClickListener(this.bvI);
        this.bwv.setOnClickListener(this.bvI);
        this.bww.setOnClickListener(this.bvI);
        this.bvN.setOnClickListener(this.bvI);
        this.bwx.setOnClickListener(this.mOnClickListener);
        this.bvL.setOnClickListener(this.mOnClickListener);
        QD();
        showLoadingView();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    private void showLoadingView() {
        if (this.bwF == null) {
            this.bwF = new BlueCircleProgressDialog(this.tbPageContext);
        }
        this.bwF.setCancelListener(null);
        this.bwF.setTipString(a.i.sdk_loading);
        this.bwF.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(VideoFileInfo videoFileInfo) {
        int i = videoFileInfo != null ? videoFileInfo.videoDuration : 0;
        if (i < 3000 || i > 600000) {
            this.bvI.showToast(a.i.sdk_ph_album_choose_video_time_tip);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD() {
        int count;
        String string;
        if (this.bvu != null && this.bvM != null) {
            if (this.bvu.Qt()) {
                int i = this.bvu.Qt() ? 1 : 0;
                count = i;
                string = this.bvI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(i), 1});
            } else {
                count = ListUtils.getCount(this.bvu.Qv());
                string = this.bvI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bvu.getMaxImagesAllowed())});
            }
            this.bvM.setText(string);
            this.bvM.setEnabled(count > 0);
        }
    }

    public void onResume() {
        this.bwE = false;
        Qi();
    }

    private void Qh() {
        if (this.bvu == null && this.bvI != null) {
            this.bvu = this.bvI.Qd();
        }
        if (this.bvu != null) {
            QE();
            cD(this.bvu.isOriginalImg());
        }
    }

    private void QE() {
        if (this.bwt == null) {
            this.bwt = new MediaStoreLoader(this.bvI);
        }
        this.bwt.loadAll(this.bvI.Qc() == 1 ? 0 : 2, new MediaStoreLoadCallback() { // from class: com.baidu.live.tieba.write.album.j.6
            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPreLoad() {
            }

            @Override // com.baidu.live.tbadk.album.MediaStoreLoadCallback
            public void onPostLoad(ResutMediaStore resutMediaStore) {
                if (j.this.bwF != null) {
                    j.this.bwF.setDialogVisiable(false);
                }
                if (resutMediaStore == null) {
                    resutMediaStore = new ResutMediaStore();
                }
                if (j.this.bvu != null && resutMediaStore != null) {
                    j.this.bvu.a(resutMediaStore);
                    String Qx = j.this.bvu.Qx();
                    j.this.bvu.hM(Qx);
                    j.this.bwA.setData(j.this.bvu.hO(Qx));
                    if (j.this.bwA.getCount() <= 0) {
                        j.this.bwB.setVisibility(0);
                    } else {
                        j.this.bwB.setVisibility(8);
                    }
                    j.this.bwz.smoothScrollToPosition(0);
                    j.this.QD();
                }
                j.this.bwz.QG();
            }
        });
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mView);
        SkinManager.setBackgroundColor(this.bwD, a.d.sdk_cp_bg_line_b, i);
        SkinManager.setViewTextColor(this.bwx, a.d.sdk_cp_cont_b, i);
        if (this.bvI.Qc() == 1) {
            SkinManager.setImageResource(this.bwv, a.f.sdk_ph_icon_topbar_close_n, i);
            this.bww.setVisibility(8);
        } else {
            SkinManager.setViewTextColor(this.bww, a.d.sdk_ph_navi_back_text_color);
            this.bwv.setVisibility(8);
        }
        if (this.bwx != null) {
            this.bwx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(a.f.sdk_ph_icon_album_spread), (Drawable) null);
        }
        if (this.bwA != null) {
            this.bwA.notifyDataSetChanged();
        }
        if (this.bvu != null) {
            cD(this.bvu.isOriginalImg());
        }
    }

    public View getView() {
        return this.mView;
    }

    public View QB() {
        return this.bvI.Qc() == 1 ? this.bwv : this.bww;
    }

    public View QF() {
        return this.bvM;
    }

    @Override // com.baidu.live.tieba.write.album.d.a
    public void cF(boolean z) {
        Qi();
    }

    private void Qi() {
        if (!this.bwE) {
            Qh();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.bwA.cG(true);
        } else if (this.bwA.isScroll()) {
            this.bwA.cG(false);
        }
    }

    public void o(int i, boolean z) {
        if (this.bwz != null) {
            int firstVisiblePosition = this.bwz.getFirstVisiblePosition();
            int lastVisiblePosition = this.bwz.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.bwz.getChildAt(i - firstVisiblePosition);
                if (childAt != null && this.bwA != null) {
                    this.bwA.b((ImageView) childAt.findViewById(a.g.select_icon), z);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        QD();
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.bwA != null) {
            o(this.bwA.e(imageFileInfo), z);
        }
    }

    public View Qo() {
        return this.bvN;
    }

    public void cD(boolean z) {
        if (this.bvI != null && this.bvN != null) {
            this.bvN.setText(this.bvI.getResources().getString(a.i.sdk_ph_original_img));
            if (z) {
                this.bvN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.bvN, a.d.sdk_cp_link_tip_a);
                return;
            }
            this.bvN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this.bvN, a.d.sdk_cp_cont_f);
        }
    }
}
