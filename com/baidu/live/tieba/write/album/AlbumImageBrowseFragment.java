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
    private ImageView aGl;
    private c bDT;
    private AlbumActivity bEh;
    private AlbumImagePagerAdapter bEi;
    private ImageView bEj;
    private View bEk;
    private TextView bEl;
    private TextView bEm;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bEk && view == AlbumImageBrowseFragment.this.bEj && AlbumImageBrowseFragment.this.bEi != null && AlbumImageBrowseFragment.this.bDT != null && AlbumImageBrowseFragment.this.bEh != null) {
                if (AlbumImageBrowseFragment.this.bDT.TW()) {
                    AlbumImageBrowseFragment.this.bEh.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bEi.fY(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo fX = AlbumImageBrowseFragment.this.bEi.fX(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bDT.isAdded(fX)) {
                        if (AlbumImageBrowseFragment.this.bEh.b(fX)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, false);
                            AlbumImageBrowseFragment.this.bEh.a(fX, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bEh.a(fX)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, true);
                        AlbumImageBrowseFragment.this.bEh.a(fX, true);
                    }
                    AlbumImageBrowseFragment.this.TJ();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bEi != null && AlbumImageBrowseFragment.this.bDT != null) {
                ImageFileInfo fX = AlbumImageBrowseFragment.this.bEi.fX(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bDT.isAdded(fX)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bEj, false);
                }
                if (fX == null || !fX.isGif()) {
                    AlbumImageBrowseFragment.this.bEm.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bEm.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cQ(AlbumImageBrowseFragment.this.bDT.isOriginalImg());
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
        this.bEh = (AlbumActivity) getBaseFragmentActivity();
        this.bDT = this.bEh.TG();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aGl = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bEj = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bEl = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bEm = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bEk = this.mRoot.findViewById(a.f.layout_bottom);
        this.aGl.setOnClickListener(this.bEh);
        this.bEl.setOnClickListener(this.bEh);
        this.bEj.setOnClickListener(this.mOnClickListener);
        this.bEm.setOnClickListener(this.bEh);
        this.bEk.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TJ() {
        this.bEh.TD();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            TL();
        }
    }

    private void TK() {
        List<ImageFileInfo> Ub;
        int currentIndex;
        if (this.bDT == null && this.bEh != null) {
            this.bDT = this.bEh.TG();
        }
        if (this.bDT != null && (Ub = this.bDT.Ub()) != null && (currentIndex = this.bDT.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bEi = new AlbumImagePagerAdapter(this.bEh);
            this.mViewPager.setAdapter(this.bEi);
            if (this.mCurrentIndex == 0 && Ub != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Ub, this.mCurrentIndex);
                if (this.bDT.isAdded(imageFileInfo)) {
                    a(this.bEj, true);
                } else {
                    a(this.bEj, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bEm.setVisibility(8);
                } else {
                    this.bEm.setVisibility(0);
                }
            }
            this.bEi.setData(Ub);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cQ(this.bDT.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bEi != null) {
            this.bEi.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aGl, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bDT != null) {
            cQ(this.bDT.isOriginalImg());
        }
        if (this.bEi != null) {
            this.bEi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bEh != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bEl != null) {
                int count = this.bDT != null ? ListUtils.getCount(this.bDT.TY()) : 0;
                this.bEl.setText(this.bEh.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bDT != null ? this.bDT.getMaxImagesAllowed() : 1)}));
                this.bEl.setEnabled(count > 0);
            }
        }
    }

    private void TL() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            TK();
        }
    }

    public void cQ(boolean z) {
        long j;
        if (this.bEh != null && this.bEm != null) {
            if (this.bEi != null) {
                ImageFileInfo fX = this.bEi.fX(this.mCurrentIndex);
                j = fX != null ? FileHelper.getFileSize(fX.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bEh.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bEm, a.c.sdk_cp_link_tip_a);
                this.bEm.setText(sb2);
                this.bEm.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bEm, a.c.sdk_cp_cont_f);
            this.bEm.setText(string);
            this.bEm.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
