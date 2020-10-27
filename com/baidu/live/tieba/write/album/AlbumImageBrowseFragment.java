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
    private ImageView aFv;
    private c bxI;
    private AlbumActivity bxW;
    private AlbumImagePagerAdapter bxX;
    private ImageView bxY;
    private View bxZ;
    private TextView bya;
    private TextView byb;
    private View mNoDataView;
    private View mRoot;
    private ViewPager mViewPager;
    private int mCurrentIndex = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bxZ && view == AlbumImageBrowseFragment.this.bxY && AlbumImageBrowseFragment.this.bxX != null && AlbumImageBrowseFragment.this.bxI != null && AlbumImageBrowseFragment.this.bxW != null) {
                if (AlbumImageBrowseFragment.this.bxI.Ro()) {
                    AlbumImageBrowseFragment.this.bxW.showToast(a.i.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bxX.fL(AlbumImageBrowseFragment.this.mCurrentIndex)) {
                    ImageFileInfo fK = AlbumImageBrowseFragment.this.bxX.fK(AlbumImageBrowseFragment.this.mCurrentIndex);
                    if (AlbumImageBrowseFragment.this.bxI.isAdded(fK)) {
                        if (AlbumImageBrowseFragment.this.bxW.b(fK)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, false);
                            AlbumImageBrowseFragment.this.bxW.a(fK, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bxW.a(fK)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, true);
                        AlbumImageBrowseFragment.this.bxW.a(fK, true);
                    }
                    AlbumImageBrowseFragment.this.Rb();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.mCurrentIndex = i;
            if (AlbumImageBrowseFragment.this.bxX != null && AlbumImageBrowseFragment.this.bxI != null) {
                ImageFileInfo fK = AlbumImageBrowseFragment.this.bxX.fK(AlbumImageBrowseFragment.this.mCurrentIndex);
                if (AlbumImageBrowseFragment.this.bxI.isAdded(fK)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bxY, false);
                }
                if (fK == null || !fK.isGif()) {
                    AlbumImageBrowseFragment.this.byb.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.byb.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.cJ(AlbumImageBrowseFragment.this.bxI.isOriginalImg());
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
        this.bxW = (AlbumActivity) getBaseFragmentActivity();
        this.bxI = this.bxW.QY();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.h.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aFv = (ImageView) this.mRoot.findViewById(a.g.img_back);
        this.bxY = (ImageView) this.mRoot.findViewById(a.g.img_choose);
        this.mViewPager = (ViewPager) this.mRoot.findViewById(a.g.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.g.album_no_data);
        this.bya = (TextView) this.mRoot.findViewById(a.g.btn_next_step);
        this.byb = (TextView) this.mRoot.findViewById(a.g.original_select_btn);
        this.bxZ = this.mRoot.findViewById(a.g.layout_bottom);
        this.aFv.setOnClickListener(this.bxW);
        this.bya.setOnClickListener(this.bxW);
        this.bxY.setOnClickListener(this.mOnClickListener);
        this.byb.setOnClickListener(this.bxW);
        this.bxZ.setOnClickListener(this.mOnClickListener);
        this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rb() {
        this.bxW.QV();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Rd();
        }
    }

    private void Rc() {
        List<ImageFileInfo> Rt;
        int currentIndex;
        if (this.bxI == null && this.bxW != null) {
            this.bxI = this.bxW.QY();
        }
        if (this.bxI != null && (Rt = this.bxI.Rt()) != null && (currentIndex = this.bxI.getCurrentIndex()) >= 0) {
            this.mCurrentIndex = currentIndex;
            this.bxX = new AlbumImagePagerAdapter(this.bxW);
            this.mViewPager.setAdapter(this.bxX);
            if (this.mCurrentIndex == 0 && Rt != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Rt, this.mCurrentIndex);
                if (this.bxI.isAdded(imageFileInfo)) {
                    a(this.bxY, true);
                } else {
                    a(this.bxY, false);
                }
                if (imageFileInfo.isGif()) {
                    this.byb.setVisibility(8);
                } else {
                    this.byb.setVisibility(0);
                }
            }
            this.bxX.setData(Rt);
            this.mViewPager.setCurrentItem(this.mCurrentIndex, false);
            cJ(this.bxI.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bxX != null) {
            this.bxX.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aFv, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg, i);
        if (this.bxI != null) {
            cJ(this.bxI.isOriginalImg());
        }
        if (this.bxX != null) {
            this.bxX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bxW != null) {
            SkinManager.setImageResource(imageView, z ? a.f.sdk_ph_ic_post_edit_select_s : a.f.sdk_ph_icon_image_clear_select);
            if (this.bya != null) {
                int count = this.bxI != null ? ListUtils.getCount(this.bxI.Rq()) : 0;
                this.bya.setText(this.bxW.getString(a.i.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bxI != null ? this.bxI.getMaxImagesAllowed() : 1)}));
                this.bya.setEnabled(count > 0);
            }
        }
    }

    private void Rd() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.mViewPager.setVisibility(0);
            Rc();
        }
    }

    public void cJ(boolean z) {
        long j;
        if (this.bxW != null && this.byb != null) {
            if (this.bxX != null) {
                ImageFileInfo fK = this.bxX.fK(this.mCurrentIndex);
                j = fK != null ? FileHelper.getFileSize(fK.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bxW.getResources().getString(a.i.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.byb, a.d.sdk_cp_link_tip_a);
                this.byb.setText(sb2);
                this.byb.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.byb, a.d.sdk_cp_cont_f);
            this.byb.setText(string);
            this.byb.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
