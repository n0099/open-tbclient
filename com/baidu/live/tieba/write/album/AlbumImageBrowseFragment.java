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
    private ImageView aFn;
    private AlbumActivity bvI;
    private AlbumImagePagerAdapter bvJ;
    private ImageView bvK;
    private View bvL;
    private TextView bvM;
    private TextView bvN;
    private c bvu;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bvL && view == AlbumImageBrowseFragment.this.bvK && AlbumImageBrowseFragment.this.bvJ != null && AlbumImageBrowseFragment.this.bvu != null && AlbumImageBrowseFragment.this.bvI != null) {
                if (AlbumImageBrowseFragment.this.bvu.Qt()) {
                    AlbumImageBrowseFragment.this.bvI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bvJ.fJ(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo fI = AlbumImageBrowseFragment.this.bvJ.fI(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bvu.isAdded(fI)) {
                        if (AlbumImageBrowseFragment.this.bvI.b(fI)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, false);
                            AlbumImageBrowseFragment.this.bvI.a(fI, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bvI.a(fI)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, true);
                        AlbumImageBrowseFragment.this.bvI.a(fI, true);
                    }
                    AlbumImageBrowseFragment.this.Qg();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bvJ != null && AlbumImageBrowseFragment.this.bvu != null) {
                ImageFileInfo fI = AlbumImageBrowseFragment.this.bvJ.fI(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bvu.isAdded(fI)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bvK, false);
                }
                if (fI == null || !fI.isGif()) {
                    AlbumImageBrowseFragment.this.bvN.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bvN.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cD(AlbumImageBrowseFragment.this.bvu.isOriginalImg());
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
        this.bvI = (AlbumActivity) getBaseFragmentActivity();
        this.bvu = this.bvI.Qd();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aFn = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.bvK = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.bvM = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.bvN = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.bvL = this.mRoot.findViewById(a.g.layout_bottom);
        this.aFn.setOnClickListener(this.bvI);
        this.bvM.setOnClickListener(this.bvI);
        this.bvK.setOnClickListener(this.mOnClickListener);
        this.bvN.setOnClickListener(this.bvI);
        this.bvL.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qg() {
        this.bvI.Qa();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Qi();
        }
    }

    private void Qh() {
        List<ImageFileInfo> Qy;
        int currentIndex;
        if (this.bvu == null && this.bvI != null) {
            this.bvu = this.bvI.Qd();
        }
        if (this.bvu != null && (Qy = this.bvu.Qy()) != null && (currentIndex = this.bvu.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bvJ = new AlbumImagePagerAdapter(this.bvI);
            this.mViewPager.setAdapter(this.bvJ);
            if (this.mCurrentIndex == 0 && Qy != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Qy, this.mCurrentIndex);
                if (this.bvu.isAdded(imageFileInfo)) {
                    a(this.bvK, true);
                } else {
                    a(this.bvK, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bvN.setVisibility(8);
                } else {
                    this.bvN.setVisibility(0);
                }
            }
            this.bvJ.setData(Qy);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cD(this.bvu.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bvJ != null) {
            this.bvJ.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aFn, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.bvu != null) {
            cD(this.bvu.isOriginalImg());
        }
        if (this.bvJ != null) {
            this.bvJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bvI != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.bvM != null) {
                int count = this.bvu != null ? ListUtils.getCount(this.bvu.Qv()) : 0;
                this.bvM.setText(this.bvI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bvu != null ? this.bvu.getMaxImagesAllowed() : 1)}));
                this.bvM.setEnabled(count > 0);
            }
        }
    }

    private void Qi() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Qh();
        }
    }

    public void cD(boolean z) {
        long j;
        if (this.bvI != null && this.bvN != null) {
            if (this.bvJ != null) {
                ImageFileInfo fI = this.bvJ.fI(this.mCurrentIndex);
                j = fI != null ? FileHelper.getFileSize(fI.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bvI.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bvN, a.d.sdk_cp_link_tip_a);
                this.bvN.setText(sb2);
                this.bvN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bvN, a.d.sdk_cp_cont_f);
            this.bvN.setText(string);
            this.bvN.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
