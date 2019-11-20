package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes6.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Nj;
    private c apa;
    private AlbumActivity apq;
    private AlbumImagePagerAdapter apu;
    private ImageView apv;
    private View apw;
    private TextView apx;
    private TextView apy;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int apz = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.apw && view == AlbumImageBrowseFragment.this.apv && AlbumImageBrowseFragment.this.apu != null && AlbumImageBrowseFragment.this.apa != null && AlbumImageBrowseFragment.this.apq != null) {
                if (AlbumImageBrowseFragment.this.apa.vX()) {
                    AlbumImageBrowseFragment.this.apq.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.apu.ch(AlbumImageBrowseFragment.this.apz)) {
                    ImageFileInfo cg = AlbumImageBrowseFragment.this.apu.cg(AlbumImageBrowseFragment.this.apz);
                    if (AlbumImageBrowseFragment.this.apa.isAdded(cg)) {
                        if (AlbumImageBrowseFragment.this.apq.b(cg)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, false);
                            AlbumImageBrowseFragment.this.apq.a(cg, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.apq.a(cg)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, true);
                        AlbumImageBrowseFragment.this.apq.a(cg, true);
                    }
                    AlbumImageBrowseFragment.this.vR();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.apz = i;
            if (AlbumImageBrowseFragment.this.apu != null && AlbumImageBrowseFragment.this.apa != null) {
                ImageFileInfo cg = AlbumImageBrowseFragment.this.apu.cg(AlbumImageBrowseFragment.this.apz);
                if (AlbumImageBrowseFragment.this.apa.isAdded(cg)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apv, false);
                }
                if (cg == null || !cg.isGif()) {
                    AlbumImageBrowseFragment.this.apy.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.apy.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.aQ(AlbumImageBrowseFragment.this.apa.isOriginalImg());
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.apq = (AlbumActivity) getBaseFragmentActivity();
        this.apa = this.apq.vH();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Nj = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.apv = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.apx = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.apy = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.apw = this.mRoot.findViewById(a.g.layout_bottom);
        this.Nj.setOnClickListener(this.apq);
        this.apx.setOnClickListener(this.apq);
        this.apv.setOnClickListener(this.mOnClickListener);
        this.apy.setOnClickListener(this.apq);
        this.apw.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR() {
        this.apq.vE();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            vV();
        }
    }

    private void vS() {
        List<ImageFileInfo> wc;
        int currentIndex;
        if (this.apa == null && this.apq != null) {
            this.apa = this.apq.vH();
        }
        if (this.apa != null && (wc = this.apa.wc()) != null && (currentIndex = this.apa.getCurrentIndex()) >= 0) {
            this.apz = currentIndex;
            this.apu = new AlbumImagePagerAdapter(this.apq);
            this.mViewPager.setAdapter(this.apu);
            if (this.apz == 0 && wc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(wc, this.apz);
                if (this.apa.isAdded(imageFileInfo)) {
                    a(this.apv, true);
                } else {
                    a(this.apv, false);
                }
                if (imageFileInfo.isGif()) {
                    this.apy.setVisibility(8);
                } else {
                    this.apy.setVisibility(0);
                }
            }
            this.apu.setData(wc);
            this.mViewPager.setCurrentItem(this.apz, false);
            aQ(this.apa.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.apu != null) {
            this.apu.setData(null);
        }
    }

    public View vT() {
        return this.Nj;
    }

    public View vU() {
        return this.apx;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Nj, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.apa != null) {
            aQ(this.apa.isOriginalImg());
        }
        if (this.apu != null) {
            this.apu.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.apq != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.apx != null) {
                int count = this.apa != null ? ListUtils.getCount(this.apa.vZ()) : 0;
                this.apx.setText(this.apq.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.apa != null ? this.apa.getMaxImagesAllowed() : 1)}));
                this.apx.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cg;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.apu != null && (cg = this.apu.cg(this.apz)) != null && cg.getFilePath() != null && cg.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.apv, z);
        }
    }

    private void vV() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            vS();
        }
    }

    public View vP() {
        return this.apy;
    }

    public void aQ(boolean z) {
        long j;
        if (this.apq != null && this.apy != null) {
            if (this.apu != null) {
                ImageFileInfo cg = this.apu.cg(this.apz);
                j = cg != null ? FileHelper.getFileSize(cg.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.apq.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.apy, a.d.sdk_cp_link_tip_a);
                this.apy.setText(sb2);
                this.apy.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.apy, a.d.sdk_cp_cont_f);
            this.apy.setText(string);
            this.apy.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
