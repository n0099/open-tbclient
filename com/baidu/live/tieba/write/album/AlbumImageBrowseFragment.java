package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes4.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView aHg;
    private AlbumActivity bHE;
    private AlbumImagePagerAdapter bHF;
    private ImageView bHG;
    private View bHH;
    private TextView bHI;
    private TextView bHJ;
    private c bHq;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bHH && view == AlbumImageBrowseFragment.this.bHG && AlbumImageBrowseFragment.this.bHF != null && AlbumImageBrowseFragment.this.bHq != null && AlbumImageBrowseFragment.this.bHE != null) {
                if (AlbumImageBrowseFragment.this.bHq.VN()) {
                    AlbumImageBrowseFragment.this.bHE.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bHF.gt(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo gs = AlbumImageBrowseFragment.this.bHF.gs(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bHq.isAdded(gs)) {
                        if (AlbumImageBrowseFragment.this.bHE.b(gs)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, false);
                            AlbumImageBrowseFragment.this.bHE.a(gs, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bHE.a(gs)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, true);
                        AlbumImageBrowseFragment.this.bHE.a(gs, true);
                    }
                    AlbumImageBrowseFragment.this.VA();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bHF != null && AlbumImageBrowseFragment.this.bHq != null) {
                ImageFileInfo gs = AlbumImageBrowseFragment.this.bHF.gs(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bHq.isAdded(gs)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHG, false);
                }
                if (gs == null || !gs.isGif()) {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bHJ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dg(AlbumImageBrowseFragment.this.bHq.isOriginalImg());
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
        this.bHE = (AlbumActivity) getBaseFragmentActivity();
        this.bHq = this.bHE.Vx();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aHg = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bHG = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bHI = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bHJ = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bHH = this.mRoot.findViewById(a.f.layout_bottom);
        this.aHg.setOnClickListener(this.bHE);
        this.bHI.setOnClickListener(this.bHE);
        this.bHG.setOnClickListener(this.mOnClickListener);
        this.bHJ.setOnClickListener(this.bHE);
        this.bHH.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.bHE.Vu();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            VC();
        }
    }

    private void VB() {
        List<ImageFileInfo> VS;
        int currentIndex;
        if (this.bHq == null && this.bHE != null) {
            this.bHq = this.bHE.Vx();
        }
        if (this.bHq != null && (VS = this.bHq.VS()) != null && (currentIndex = this.bHq.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bHF = new AlbumImagePagerAdapter(this.bHE);
            this.mViewPager.setAdapter(this.bHF);
            if (this.mCurrentIndex == 0 && VS != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(VS, this.mCurrentIndex);
                if (this.bHq.isAdded(imageFileInfo)) {
                    a(this.bHG, true);
                } else {
                    a(this.bHG, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bHJ.setVisibility(8);
                } else {
                    this.bHJ.setVisibility(0);
                }
            }
            this.bHF.setData(VS);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            dg(this.bHq.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bHF != null) {
            this.bHF.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aHg, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bHq != null) {
            dg(this.bHq.isOriginalImg());
        }
        if (this.bHF != null) {
            this.bHF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bHE != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bHI != null) {
                int count = this.bHq != null ? ListUtils.getCount(this.bHq.VP()) : 0;
                this.bHI.setText(this.bHE.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bHq != null ? this.bHq.getMaxImagesAllowed() : 1)}));
                this.bHI.setEnabled(count > 0);
            }
        }
    }

    private void VC() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            VB();
        }
    }

    public void dg(boolean z) {
        long j;
        if (this.bHE != null && this.bHJ != null) {
            if (this.bHF != null) {
                ImageFileInfo gs = this.bHF.gs(this.mCurrentIndex);
                j = gs != null ? FileHelper.getFileSize(gs.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bHE.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bHJ, a.c.sdk_cp_link_tip_a);
                this.bHJ.setText(sb2);
                this.bHJ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bHJ, a.c.sdk_cp_cont_f);
            this.bHJ.setText(string);
            this.bHJ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
