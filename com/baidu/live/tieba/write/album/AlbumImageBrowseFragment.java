package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private c aVP;
    private AlbumActivity aWd;
    private AlbumImagePagerAdapter aWh;
    private ImageView aWi;
    private View aWj;
    private TextView aWk;
    private TextView aWl;
    private ImageView aor;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.aWj && view == AlbumImageBrowseFragment.this.aWi && AlbumImageBrowseFragment.this.aWh != null && AlbumImageBrowseFragment.this.aVP != null && AlbumImageBrowseFragment.this.aWd != null) {
                if (AlbumImageBrowseFragment.this.aVP.FJ()) {
                    AlbumImageBrowseFragment.this.aWd.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.aWh.df(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo de2 = AlbumImageBrowseFragment.this.aWh.de(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.aVP.isAdded(de2)) {
                        if (AlbumImageBrowseFragment.this.aWd.b(de2)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, false);
                            AlbumImageBrowseFragment.this.aWd.a(de2, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.aWd.a(de2)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, true);
                        AlbumImageBrowseFragment.this.aWd.a(de2, true);
                    }
                    AlbumImageBrowseFragment.this.FD();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.aWh != null && AlbumImageBrowseFragment.this.aVP != null) {
                ImageFileInfo de2 = AlbumImageBrowseFragment.this.aWh.de(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.aVP.isAdded(de2)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.aWi, false);
                }
                if (de2 == null || !de2.isGif()) {
                    AlbumImageBrowseFragment.this.aWl.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.aWl.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bY(AlbumImageBrowseFragment.this.aVP.isOriginalImg());
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
        this.aWd = (AlbumActivity) getBaseFragmentActivity();
        this.aVP = this.aWd.Ft();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aor = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.aWi = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.aWk = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.aWl = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.aWj = this.mRoot.findViewById(a.g.layout_bottom);
        this.aor.setOnClickListener(this.aWd);
        this.aWk.setOnClickListener(this.aWd);
        this.aWi.setOnClickListener(this.mOnClickListener);
        this.aWl.setOnClickListener(this.aWd);
        this.aWj.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        this.aWd.Fq();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            FH();
        }
    }

    private void FE() {
        List<ImageFileInfo> FO;
        int currentIndex;
        if (this.aVP == null && this.aWd != null) {
            this.aVP = this.aWd.Ft();
        }
        if (this.aVP != null && (FO = this.aVP.FO()) != null && (currentIndex = this.aVP.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.aWh = new AlbumImagePagerAdapter(this.aWd);
            this.mViewPager.setAdapter(this.aWh);
            if (this.mCurrentIndex == 0 && FO != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(FO, this.mCurrentIndex);
                if (this.aVP.isAdded(imageFileInfo)) {
                    a(this.aWi, true);
                } else {
                    a(this.aWi, false);
                }
                if (imageFileInfo.isGif()) {
                    this.aWl.setVisibility(8);
                } else {
                    this.aWl.setVisibility(0);
                }
            }
            this.aWh.setData(FO);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bY(this.aVP.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.aWh != null) {
            this.aWh.setData(null);
        }
    }

    public View FF() {
        return this.aor;
    }

    public View FG() {
        return this.aWk;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aor, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.aVP != null) {
            bY(this.aVP.isOriginalImg());
        }
        if (this.aWh != null) {
            this.aWh.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.aWd != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.aWk != null) {
                int count = this.aVP != null ? ListUtils.getCount(this.aVP.FL()) : 0;
                this.aWk.setText(this.aWd.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.aVP != null ? this.aVP.getMaxImagesAllowed() : 1)}));
                this.aWk.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo de2;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.aWh != null && (de2 = this.aWh.de(this.mCurrentIndex)) != null && de2.getFilePath() != null && de2.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.aWi, z);
        }
    }

    private void FH() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            FE();
        }
    }

    public View FB() {
        return this.aWl;
    }

    public void bY(boolean z) {
        long j;
        if (this.aWd != null && this.aWl != null) {
            if (this.aWh != null) {
                ImageFileInfo de2 = this.aWh.de(this.mCurrentIndex);
                j = de2 != null ? FileHelper.getFileSize(de2.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.aWd.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.aWl, a.d.sdk_cp_link_tip_a);
                this.aWl.setText(sb2);
                this.aWl.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.aWl, a.d.sdk_cp_cont_f);
            this.aWl.setText(string);
            this.aWl.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
