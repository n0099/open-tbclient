package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
/* loaded from: classes4.dex */
public class h {
    private ImageView aCi;
    private c brG;
    private AlbumActivity brU;
    private AlbumImagePagerAdapter brV;
    private ImageView brW;
    private View brX;
    private TextView brY;
    private TextView brZ;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private TbPageContext tbPageContext;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.brX && view == h.this.brW && h.this.brV != null && h.this.brG != null && h.this.brU != null) {
                if (h.this.brG.Po()) {
                    h.this.brU.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (h.this.brV.fA(h.this.mCurrentIndex)) {
                    ImageFileInfo fz = h.this.brV.fz(h.this.mCurrentIndex);
                    if (h.this.brG.isAdded(fz)) {
                        if (h.this.brU.b(fz)) {
                            h.this.a(h.this.brW, false);
                            h.this.brU.a(fz, false);
                        }
                    } else if (h.this.brU.a(fz)) {
                        h.this.a(h.this.brW, true);
                        h.this.brU.a(fz, true);
                    }
                    h.this.Pb();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.mCurrentIndex = i;
            if (h.this.brV != null && h.this.brG != null) {
                ImageFileInfo fz = h.this.brV.fz(h.this.mCurrentIndex);
                if (h.this.brG.isAdded(fz)) {
                    h.this.a(h.this.brW, true);
                } else {
                    h.this.a(h.this.brW, false);
                }
                if (fz == null || !fz.isGif()) {
                    h.this.brZ.setVisibility(0);
                } else {
                    h.this.brZ.setVisibility(8);
                }
                h.this.cA(h.this.brG.isOriginalImg());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    public h(TbPageContext tbPageContext, AlbumActivity albumActivity) {
        this.tbPageContext = tbPageContext;
        this.brU = albumActivity;
        this.brG = this.brU.OY();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.brU).inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aCi = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.brW = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.brY = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.brZ = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.brX = this.mRoot.findViewById(a.g.layout_bottom);
        this.aCi.setOnClickListener(this.brU);
        this.brY.setOnClickListener(this.brU);
        this.brW.setOnClickListener(this.mOnClickListener);
        this.brZ.setOnClickListener(this.brU);
        this.brX.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pb() {
        this.brU.OV();
    }

    public void onResume() {
        Pd();
    }

    private void Pc() {
        List<ImageFileInfo> Pt;
        int currentIndex;
        if (this.brG == null && this.brU != null) {
            this.brG = this.brU.OY();
        }
        if (this.brG != null && (Pt = this.brG.Pt()) != null && (currentIndex = this.brG.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.brV = new AlbumImagePagerAdapter(this.brU);
            this.mViewPager.setAdapter(this.brV);
            if (this.mCurrentIndex == 0 && Pt != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Pt, this.mCurrentIndex);
                if (this.brG.isAdded(imageFileInfo)) {
                    a(this.brW, true);
                } else {
                    a(this.brW, false);
                }
                if (imageFileInfo.isGif()) {
                    this.brZ.setVisibility(8);
                } else {
                    this.brZ.setVisibility(0);
                }
            }
            this.brV.setData(Pt);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cA(this.brG.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View Pw() {
        return this.aCi;
    }

    public View Px() {
        return this.brY;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aCi, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.brG != null) {
            cA(this.brG.isOriginalImg());
        }
        if (this.brV != null) {
            this.brV.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.brU != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.brY != null) {
                int count = this.brG != null ? ListUtils.getCount(this.brG.Pq()) : 0;
                this.brY.setText(this.brU.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.brG != null ? this.brG.getMaxImagesAllowed() : 1)}));
                this.brY.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo fz;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.brV != null && (fz = this.brV.fz(this.mCurrentIndex)) != null && fz.getFilePath() != null && fz.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.brW, z);
        }
    }

    private void Pd() {
        this.mNoDataView.setVisibility(8);
        this.mViewPager.setVisibility(0);
        Pc();
    }

    public View Pj() {
        return this.brZ;
    }

    public void cA(boolean z) {
        long j;
        if (this.brU != null && this.brZ != null) {
            if (this.brV != null) {
                ImageFileInfo fz = this.brV.fz(this.mCurrentIndex);
                j = fz != null ? FileHelper.getFileSize(fz.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.brU.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.brZ, a.d.sdk_cp_link_tip_a);
                this.brZ.setText(sb2);
                this.brZ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.brZ, a.d.sdk_cp_cont_f);
            this.brZ.setText(string);
            this.brZ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
