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
    private ViewPager Zi;
    private ImageView aCK;
    private AlbumActivity bHF;
    private AlbumImagePagerAdapter bHG;
    private ImageView bHH;
    private View bHI;
    private TextView bHJ;
    private TextView bHK;
    private c bHr;
    private View mNoDataView;
    private View mRoot;
    private TbPageContext tbPageContext;
    private int bHL = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != h.this.bHI && view == h.this.bHH && h.this.bHG != null && h.this.bHr != null && h.this.bHF != null) {
                if (h.this.bHr.SX()) {
                    h.this.bHF.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (h.this.bHG.eN(h.this.bHL)) {
                    ImageFileInfo eM = h.this.bHG.eM(h.this.bHL);
                    if (h.this.bHr.isAdded(eM)) {
                        if (h.this.bHF.b(eM)) {
                            h.this.a(h.this.bHH, false);
                            h.this.bHF.a(eM, false);
                        }
                    } else if (h.this.bHF.a(eM)) {
                        h.this.a(h.this.bHH, true);
                        h.this.bHF.a(eM, true);
                    }
                    h.this.SK();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.h.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            h.this.bHL = i;
            if (h.this.bHG != null && h.this.bHr != null) {
                ImageFileInfo eM = h.this.bHG.eM(h.this.bHL);
                if (h.this.bHr.isAdded(eM)) {
                    h.this.a(h.this.bHH, true);
                } else {
                    h.this.a(h.this.bHH, false);
                }
                if (eM == null || !eM.isGif()) {
                    h.this.bHK.setVisibility(0);
                } else {
                    h.this.bHK.setVisibility(8);
                }
                h.this.df(h.this.bHr.isOriginalImg());
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
        this.bHF = albumActivity;
        this.bHr = this.bHF.SH();
        initView();
    }

    public void initView() {
        this.mRoot = LayoutInflater.from(this.bHF).inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aCK = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bHH = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.Zi = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bHJ = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bHK = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bHI = this.mRoot.findViewById(a.f.layout_bottom);
        this.aCK.setOnClickListener(this.bHF);
        this.bHJ.setOnClickListener(this.bHF);
        this.bHH.setOnClickListener(this.mOnClickListener);
        this.bHK.setOnClickListener(this.bHF);
        this.bHI.setOnClickListener(this.mOnClickListener);
        this.Zi.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        this.bHF.SE();
    }

    public void onResume() {
        SM();
    }

    private void SL() {
        List<ImageFileInfo> Tc;
        int currentIndex;
        if (this.bHr == null && this.bHF != null) {
            this.bHr = this.bHF.SH();
        }
        if (this.bHr != null && (Tc = this.bHr.Tc()) != null && (currentIndex = this.bHr.getCurrentIndex()) >= 0) {
            this.bHL = currentIndex;
            this.bHG = new AlbumImagePagerAdapter(this.bHF);
            this.Zi.setAdapter(this.bHG);
            if (this.bHL == 0 && Tc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Tc, this.bHL);
                if (this.bHr.isAdded(imageFileInfo)) {
                    a(this.bHH, true);
                } else {
                    a(this.bHH, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bHK.setVisibility(8);
                } else {
                    this.bHK.setVisibility(0);
                }
            }
            this.bHG.setData(Tc);
            this.Zi.setCurrentItem(this.bHL, false);
            df(this.bHr.isOriginalImg());
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public View Tf() {
        return this.aCK;
    }

    public View Tg() {
        return this.bHJ;
    }

    public void onChangeSkinType(int i) {
        SkinUtil.onModeChanged(this.tbPageContext, this.mRoot);
        SkinManager.setNavbarIconSrc(this.aCK, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bHr != null) {
            df(this.bHr.isOriginalImg());
        }
        if (this.bHG != null) {
            this.bHG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bHF != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bHJ != null) {
                int count = this.bHr != null ? ListUtils.getCount(this.bHr.SZ()) : 0;
                this.bHJ.setText(this.bHF.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bHr != null ? this.bHr.getMaxImagesAllowed() : 1)}));
                this.bHJ.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo eM;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.bHG != null && (eM = this.bHG.eM(this.bHL)) != null && eM.getFilePath() != null && eM.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.bHH, z);
        }
    }

    private void SM() {
        this.mNoDataView.setVisibility(8);
        this.Zi.setVisibility(0);
        SL();
    }

    public View SS() {
        return this.bHK;
    }

    public void df(boolean z) {
        long j;
        if (this.bHF != null && this.bHK != null) {
            if (this.bHG != null) {
                ImageFileInfo eM = this.bHG.eM(this.bHL);
                j = eM != null ? FileHelper.getFileSize(eM.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bHF.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_link_tip_a);
                this.bHK.setText(sb2);
                this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_cont_f);
            this.bHK.setText(string);
            this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
