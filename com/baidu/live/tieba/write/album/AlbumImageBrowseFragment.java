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
    private ImageView NK;
    private AlbumActivity apI;
    private AlbumImagePagerAdapter apM;
    private ImageView apN;
    private View apO;
    private TextView apP;
    private TextView apQ;
    private c apt;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int apR = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.apO && view == AlbumImageBrowseFragment.this.apN && AlbumImageBrowseFragment.this.apM != null && AlbumImageBrowseFragment.this.apt != null && AlbumImageBrowseFragment.this.apI != null) {
                if (AlbumImageBrowseFragment.this.apt.vW()) {
                    AlbumImageBrowseFragment.this.apI.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.apM.ch(AlbumImageBrowseFragment.this.apR)) {
                    ImageFileInfo cg = AlbumImageBrowseFragment.this.apM.cg(AlbumImageBrowseFragment.this.apR);
                    if (AlbumImageBrowseFragment.this.apt.isAdded(cg)) {
                        if (AlbumImageBrowseFragment.this.apI.b(cg)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, false);
                            AlbumImageBrowseFragment.this.apI.a(cg, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.apI.a(cg)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, true);
                        AlbumImageBrowseFragment.this.apI.a(cg, true);
                    }
                    AlbumImageBrowseFragment.this.vQ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.apR = i;
            if (AlbumImageBrowseFragment.this.apM != null && AlbumImageBrowseFragment.this.apt != null) {
                ImageFileInfo cg = AlbumImageBrowseFragment.this.apM.cg(AlbumImageBrowseFragment.this.apR);
                if (AlbumImageBrowseFragment.this.apt.isAdded(cg)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.apN, false);
                }
                if (cg == null || !cg.isGif()) {
                    AlbumImageBrowseFragment.this.apQ.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.apQ.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.aQ(AlbumImageBrowseFragment.this.apt.isOriginalImg());
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
        this.apI = (AlbumActivity) getBaseFragmentActivity();
        this.apt = this.apI.vG();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.NK = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.apN = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.apP = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.apQ = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.apO = this.mRoot.findViewById(a.g.layout_bottom);
        this.NK.setOnClickListener(this.apI);
        this.apP.setOnClickListener(this.apI);
        this.apN.setOnClickListener(this.mOnClickListener);
        this.apQ.setOnClickListener(this.apI);
        this.apO.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
        this.apI.vD();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            vU();
        }
    }

    private void vR() {
        List<ImageFileInfo> wb;
        int currentIndex;
        if (this.apt == null && this.apI != null) {
            this.apt = this.apI.vG();
        }
        if (this.apt != null && (wb = this.apt.wb()) != null && (currentIndex = this.apt.getCurrentIndex()) >= 0) {
            this.apR = currentIndex;
            this.apM = new AlbumImagePagerAdapter(this.apI);
            this.mViewPager.setAdapter(this.apM);
            if (this.apR == 0 && wb != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(wb, this.apR);
                if (this.apt.isAdded(imageFileInfo)) {
                    a(this.apN, true);
                } else {
                    a(this.apN, false);
                }
                if (imageFileInfo.isGif()) {
                    this.apQ.setVisibility(8);
                } else {
                    this.apQ.setVisibility(0);
                }
            }
            this.apM.setData(wb);
            this.mViewPager.setCurrentItem(this.apR, false);
            aQ(this.apt.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.apM != null) {
            this.apM.setData(null);
        }
    }

    public View vS() {
        return this.NK;
    }

    public View vT() {
        return this.apP;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.NK, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.apt != null) {
            aQ(this.apt.isOriginalImg());
        }
        if (this.apM != null) {
            this.apM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.apI != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.apP != null) {
                int count = this.apt != null ? ListUtils.getCount(this.apt.vY()) : 0;
                this.apP.setText(this.apI.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.apt != null ? this.apt.getMaxImagesAllowed() : 1)}));
                this.apP.setEnabled(count > 0);
            }
        }
    }

    public void c(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo cg;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.apM != null && (cg = this.apM.cg(this.apR)) != null && cg.getFilePath() != null && cg.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.apN, z);
        }
    }

    private void vU() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            vR();
        }
    }

    public View vO() {
        return this.apQ;
    }

    public void aQ(boolean z) {
        long j;
        if (this.apI != null && this.apQ != null) {
            if (this.apM != null) {
                ImageFileInfo cg = this.apM.cg(this.apR);
                j = cg != null ? FileHelper.getFileSize(cg.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.apI.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.apQ, a.d.sdk_cp_link_tip_a);
                this.apQ.setText(sb2);
                this.apQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.apQ, a.d.sdk_cp_cont_f);
            this.apQ.setText(string);
            this.apQ.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
