package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes11.dex */
public class h {
    private ViewPager Ze;
    private ImageView aEx;
    private c bLb;
    private AlbumActivity bLp;
    private AlbumImagePagerAdapter bLq;
    private ImageView bLr;
    private View bLs;
    private TextView bLt;
    private TextView bLu;
    private View mNoDataView;
    private View mRoot;
    private TbPageContext tbPageContext;
    private int bLv = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bLs && view == h.this.bLr && h.this.bLq != null && h.this.bLb != null && h.this.bLp != null) {
                if (h.this.bLb.UE()) {
                    h.this.bLp.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bLq.eR(h.this.bLv)) {
                    ImageFileInfo eQ = h.this.bLq.eQ(h.this.bLv);
                    if (h.this.bLb.isAdded(eQ)) {
                        if (h.this.bLp.b(eQ)) {
                            h.this.a(h.this.bLr, false);
                            h.this.bLp.a(eQ, false);
                        }
                    } else if (h.this.bLp.a(eQ)) {
                        h.this.a(h.this.bLr, true);
                        h.this.bLp.a(eQ, true);
                    }
                    h.this.Ur();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.bLv = i;
            if (h.this.bLq != null && h.this.bLb != null) {
                ImageFileInfo eQ = h.this.bLq.eQ(h.this.bLv);
                if (h.this.bLb.isAdded(eQ)) {
                    h.this.a(h.this.bLr, true);
                } else {
                    h.this.a(h.this.bLr, false);
                }
                if (eQ == null || !eQ.isGif()) {
                    h.this.bLu.setVisibility(0);
                } else {
                    h.this.bLu.setVisibility(8);
                }
                h.this.dn(h.this.bLb.isOriginalImg());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public h(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.bLp = albumActivity;
        this.bLb = this.bLp.Uo();
        initView();
    }

    public final void initView() {
        this.mRoot = LayoutInflater.from(this.bLp).inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aEx = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bLr = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.Ze = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bLt = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bLu = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bLs = this.mRoot.findViewById(a.f.layout_bottom);
        this.aEx.setOnClickListener(this.bLp);
        this.bLt.setOnClickListener(this.bLp);
        this.bLr.setOnClickListener(this.mOnClickListener);
        this.bLu.setOnClickListener(this.bLp);
        this.bLs.setOnClickListener(this.mOnClickListener);
        this.Ze.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        this.bLp.Ul();
    }

    public void onResume() {
        Ut();
    }

    private void Us() {
        List<ImageFileInfo> UJ;
        int currentIndex;
        if (this.bLb == null && this.bLp != null) {
            this.bLb = this.bLp.Uo();
        }
        if (this.bLb != null && (UJ = this.bLb.UJ()) != null && (currentIndex = this.bLb.getCurrentIndex()) >= 0) {
            this.bLv = currentIndex;
            this.bLq = new AlbumImagePagerAdapter(this.bLp);
            this.Ze.setAdapter(this.bLq);
            if (this.bLv == 0 && UJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(UJ, this.bLv);
                if (this.bLb.isAdded(imageFileInfo)) {
                    a(this.bLr, true);
                } else {
                    a(this.bLr, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bLu.setVisibility(8);
                } else {
                    this.bLu.setVisibility(0);
                }
            }
            this.bLq.setData(UJ);
            this.Ze.setCurrentItem(this.bLv, false);
            dn(this.bLb.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View UM() {
        return this.aEx;
    }

    public View UN() {
        return this.bLt;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aEx, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bLb != null) {
            dn(this.bLb.isOriginalImg());
        }
        if (this.bLq != null) {
            this.bLq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bLp != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bLt != null) {
                int count = this.bLb != null ? ListUtils.getCount(this.bLb.UG()) : 0;
                this.bLt.setText(this.bLp.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bLb != null ? this.bLb.getMaxImagesAllowed() : 1)}));
                this.bLt.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo eQ;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bLq != null && (eQ = this.bLq.eQ(this.bLv)) != null && eQ.getFilePath() != null && eQ.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bLr, z);
        }
    }

    private void Ut() {
        this.mNoDataView.setVisibility(8);
        this.Ze.setVisibility(0);
        Us();
    }

    public View Uz() {
        return this.bLu;
    }

    public void dn(boolean z) {
        long j;
        if (this.bLp != null && this.bLu != null) {
            if (this.bLq != null) {
                ImageFileInfo eQ = this.bLq.eQ(this.bLv);
                j = eQ != null ? FileHelper.getFileSize(eQ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bLp.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_link_tip_a);
                this.bLu.setText(sb2);
                this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_cont_f);
            this.bLu.setText(string);
            this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
