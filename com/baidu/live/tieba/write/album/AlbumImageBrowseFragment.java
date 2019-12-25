package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.FileHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.skin.SkinUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ImageView Ug;
    private c awT;
    private AlbumActivity axh;
    private AlbumImagePagerAdapter axl;
    private ImageView axm;
    private View axn;
    private TextView axo;
    private TextView axp;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.axn && view == AlbumImageBrowseFragment.this.axm && AlbumImageBrowseFragment.this.axl != null && AlbumImageBrowseFragment.this.awT != null && AlbumImageBrowseFragment.this.axh != null) {
                if (AlbumImageBrowseFragment.this.awT.xV()) {
                    AlbumImageBrowseFragment.this.axh.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.axl.cz(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo cy = AlbumImageBrowseFragment.this.axl.cy(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.awT.isAdded(cy)) {
                        if (AlbumImageBrowseFragment.this.axh.b(cy)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, false);
                            AlbumImageBrowseFragment.this.axh.a(cy, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.axh.a(cy)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, true);
                        AlbumImageBrowseFragment.this.axh.a(cy, true);
                    }
                    AlbumImageBrowseFragment.this.xP();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.axl != null && AlbumImageBrowseFragment.this.awT != null) {
                ImageFileInfo cy = AlbumImageBrowseFragment.this.axl.cy(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.awT.isAdded(cy)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.axm, false);
                }
                if (cy == null || !cy.isGif()) {
                    AlbumImageBrowseFragment.this.axp.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.axp.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.bh(AlbumImageBrowseFragment.this.awT.isOriginalImg());
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
        this.axh = (AlbumActivity) getBaseFragmentActivity();
        this.awT = this.axh.xF();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.Ug = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.axm = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.axo = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.axp = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.axn = this.mRoot.findViewById(a.g.layout_bottom);
        this.Ug.setOnClickListener(this.axh);
        this.axo.setOnClickListener(this.axh);
        this.axm.setOnClickListener(this.mOnClickListener);
        this.axp.setOnClickListener(this.axh);
        this.axn.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP() {
        this.axh.xC();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            xT();
        }
    }

    private void xQ() {
        List<ImageFileInfo> ya;
        int currentIndex;
        if (this.awT == null && this.axh != null) {
            this.awT = this.axh.xF();
        }
        if (this.awT != null && (ya = this.awT.ya()) != null && (currentIndex = this.awT.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.axl = new AlbumImagePagerAdapter(this.axh);
            this.mViewPager.setAdapter(this.axl);
            if (this.mCurrentIndex == 0 && ya != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(ya, this.mCurrentIndex);
                if (this.awT.isAdded(imageFileInfo)) {
                    a(this.axm, true);
                } else {
                    a(this.axm, false);
                }
                if (imageFileInfo.isGif()) {
                    this.axp.setVisibility(8);
                } else {
                    this.axp.setVisibility(0);
                }
            }
            this.axl.setData(ya);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            bh(this.awT.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.axl != null) {
            this.axl.setData(null);
        }
    }

    public View xR() {
        return this.Ug;
    }

    public View xS() {
        return this.axo;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.Ug, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.awT != null) {
            bh(this.awT.isOriginalImg());
        }
        if (this.axl != null) {
            this.axl.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.axh != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.axo != null) {
                int count = this.awT != null ? ListUtils.getCount(this.awT.xX()) : 0;
                this.axo.setText(this.axh.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.awT != null ? this.awT.getMaxImagesAllowed() : 1)}));
                this.axo.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cy;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.axl != null && (cy = this.axl.cy(this.mCurrentIndex)) != null && cy.getFilePath() != null && cy.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.axm, z);
        }
    }

    private void xT() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            xQ();
        }
    }

    public View xN() {
        return this.axp;
    }

    public void bh(boolean z) {
        long j;
        if (this.axh != null && this.axp != null) {
            if (this.axl != null) {
                ImageFileInfo cy = this.axl.cy(this.mCurrentIndex);
                j = cy != null ? FileHelper.getFileSize(cy.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.axh.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.axp, a.d.sdk_cp_link_tip_a);
                this.axp.setText(sb2);
                this.axp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.axp, a.d.sdk_cp_cont_f);
            this.axp.setText(string);
            this.axp.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
