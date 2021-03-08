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
/* loaded from: classes10.dex */
public class h {
    private ImageView aFX;
    private ViewPager aaw;
    private c bMB;
    private AlbumActivity bMP;
    private AlbumImagePagerAdapter bMQ;
    private ImageView bMR;
    private View bMS;
    private TextView bMT;
    private TextView bMU;
    private View mNoDataView;
    private View mRoot;
    private TbPageContext tbPageContext;
    private int bMV = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bMS && view == h.this.bMR && h.this.bMQ != null && h.this.bMB != null && h.this.bMP != null) {
                if (h.this.bMB.UH()) {
                    h.this.bMP.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bMQ.eS(h.this.bMV)) {
                    ImageFileInfo eR = h.this.bMQ.eR(h.this.bMV);
                    if (h.this.bMB.isAdded(eR)) {
                        if (h.this.bMP.b(eR)) {
                            h.this.a(h.this.bMR, false);
                            h.this.bMP.a(eR, false);
                        }
                    } else if (h.this.bMP.a(eR)) {
                        h.this.a(h.this.bMR, true);
                        h.this.bMP.a(eR, true);
                    }
                    h.this.Uu();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.bMV = i;
            if (h.this.bMQ != null && h.this.bMB != null) {
                ImageFileInfo eR = h.this.bMQ.eR(h.this.bMV);
                if (h.this.bMB.isAdded(eR)) {
                    h.this.a(h.this.bMR, true);
                } else {
                    h.this.a(h.this.bMR, false);
                }
                if (eR == null || !eR.isGif()) {
                    h.this.bMU.setVisibility(0);
                } else {
                    h.this.bMU.setVisibility(8);
                }
                h.this.dn(h.this.bMB.isOriginalImg());
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
        this.bMP = albumActivity;
        this.bMB = this.bMP.Ur();
        initView();
    }

    public final void initView() {
        this.mRoot = LayoutInflater.from(this.bMP).inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aFX = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bMR = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.aaw = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bMT = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bMU = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bMS = this.mRoot.findViewById(a.f.layout_bottom);
        this.aFX.setOnClickListener(this.bMP);
        this.bMT.setOnClickListener(this.bMP);
        this.bMR.setOnClickListener(this.mOnClickListener);
        this.bMU.setOnClickListener(this.bMP);
        this.bMS.setOnClickListener(this.mOnClickListener);
        this.aaw.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uu() {
        this.bMP.Uo();
    }

    public void onResume() {
        Uw();
    }

    private void Uv() {
        List<ImageFileInfo> UM;
        int currentIndex;
        if (this.bMB == null && this.bMP != null) {
            this.bMB = this.bMP.Ur();
        }
        if (this.bMB != null && (UM = this.bMB.UM()) != null && (currentIndex = this.bMB.getCurrentIndex()) >= 0) {
            this.bMV = currentIndex;
            this.bMQ = new AlbumImagePagerAdapter(this.bMP);
            this.aaw.setAdapter(this.bMQ);
            if (this.bMV == 0 && UM != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(UM, this.bMV);
                if (this.bMB.isAdded(imageFileInfo)) {
                    a(this.bMR, true);
                } else {
                    a(this.bMR, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bMU.setVisibility(8);
                } else {
                    this.bMU.setVisibility(0);
                }
            }
            this.bMQ.setData(UM);
            this.aaw.setCurrentItem(this.bMV, false);
            dn(this.bMB.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View UP() {
        return this.aFX;
    }

    public View UQ() {
        return this.bMT;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aFX, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bMB != null) {
            dn(this.bMB.isOriginalImg());
        }
        if (this.bMQ != null) {
            this.bMQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bMP != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bMT != null) {
                int count = this.bMB != null ? ListUtils.getCount(this.bMB.UJ()) : 0;
                this.bMT.setText(this.bMP.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bMB != null ? this.bMB.getMaxImagesAllowed() : 1)}));
                this.bMT.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo eR;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bMQ != null && (eR = this.bMQ.eR(this.bMV)) != null && eR.getFilePath() != null && eR.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bMR, z);
        }
    }

    private void Uw() {
        this.mNoDataView.setVisibility(8);
        this.aaw.setVisibility(0);
        Uv();
    }

    public View UC() {
        return this.bMU;
    }

    public void dn(boolean z) {
        long j;
        if (this.bMP != null && this.bMU != null) {
            if (this.bMQ != null) {
                ImageFileInfo eR = this.bMQ.eR(this.bMV);
                j = eR != null ? FileHelper.getFileSize(eR.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bMP.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bMU, a.c.sdk_cp_link_tip_a);
                this.bMU.setText(sb2);
                this.bMU.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bMU, a.c.sdk_cp_cont_f);
            this.bMU.setText(string);
            this.bMU.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
