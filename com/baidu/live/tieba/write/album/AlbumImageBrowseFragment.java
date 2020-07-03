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
/* loaded from: classes3.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView avt;
    private AlbumActivity biJ;
    private AlbumImagePagerAdapter biK;
    private ImageView biL;
    private View biM;
    private TextView biN;
    private TextView biO;
    private c biv;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.biM && view == AlbumImageBrowseFragment.this.biL && AlbumImageBrowseFragment.this.biK != null && AlbumImageBrowseFragment.this.biv != null && AlbumImageBrowseFragment.this.biJ != null) {
                if (AlbumImageBrowseFragment.this.biv.IM()) {
                    AlbumImageBrowseFragment.this.biJ.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.biK.dw(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo dv = AlbumImageBrowseFragment.this.biK.dv(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.biv.isAdded(dv)) {
                        if (AlbumImageBrowseFragment.this.biJ.b(dv)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, false);
                            AlbumImageBrowseFragment.this.biJ.a(dv, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.biJ.a(dv)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, true);
                        AlbumImageBrowseFragment.this.biJ.a(dv, true);
                    }
                    AlbumImageBrowseFragment.this.Iz();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.biK != null && AlbumImageBrowseFragment.this.biv != null) {
                ImageFileInfo dv = AlbumImageBrowseFragment.this.biK.dv(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.biv.isAdded(dv)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.biL, false);
                }
                if (dv == null || !dv.isGif()) {
                    AlbumImageBrowseFragment.this.biO.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.biO.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cn(AlbumImageBrowseFragment.this.biv.isOriginalImg());
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
        this.biJ = (AlbumActivity) getBaseFragmentActivity();
        this.biv = this.biJ.Iw();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.avt = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.biL = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.biN = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.biO = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.biM = this.mRoot.findViewById(a.g.layout_bottom);
        this.avt.setOnClickListener(this.biJ);
        this.biN.setOnClickListener(this.biJ);
        this.biL.setOnClickListener(this.mOnClickListener);
        this.biO.setOnClickListener(this.biJ);
        this.biM.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz() {
        this.biJ.It();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            IB();
        }
    }

    private void IA() {
        List<ImageFileInfo> IR;
        int currentIndex;
        if (this.biv == null && this.biJ != null) {
            this.biv = this.biJ.Iw();
        }
        if (this.biv != null && (IR = this.biv.IR()) != null && (currentIndex = this.biv.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.biK = new AlbumImagePagerAdapter(this.biJ);
            this.mViewPager.setAdapter(this.biK);
            if (this.mCurrentIndex == 0 && IR != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(IR, this.mCurrentIndex);
                if (this.biv.isAdded(imageFileInfo)) {
                    a(this.biL, true);
                } else {
                    a(this.biL, false);
                }
                if (imageFileInfo.isGif()) {
                    this.biO.setVisibility(8);
                } else {
                    this.biO.setVisibility(0);
                }
            }
            this.biK.setData(IR);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cn(this.biv.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.biK != null) {
            this.biK.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.avt, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.biv != null) {
            cn(this.biv.isOriginalImg());
        }
        if (this.biK != null) {
            this.biK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.biJ != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.biN != null) {
                int count = this.biv != null ? ListUtils.getCount(this.biv.IO()) : 0;
                this.biN.setText(this.biJ.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.biv != null ? this.biv.getMaxImagesAllowed() : 1)}));
                this.biN.setEnabled(count > 0);
            }
        }
    }

    private void IB() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            IA();
        }
    }

    public void cn(boolean z) {
        long j;
        if (this.biJ != null && this.biO != null) {
            if (this.biK != null) {
                ImageFileInfo dv = this.biK.dv(this.mCurrentIndex);
                j = dv != null ? FileHelper.getFileSize(dv.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.biJ.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.biO, a.d.sdk_cp_link_tip_a);
                this.biO.setText(sb2);
                this.biO.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.biO, a.d.sdk_cp_cont_f);
            this.biO.setText(string);
            this.biO.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
