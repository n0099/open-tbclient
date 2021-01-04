package com.baidu.live.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
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
/* loaded from: classes11.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ViewPager Zk;
    private ImageView aHx;
    private c bMd;
    private AlbumActivity bMr;
    private AlbumImagePagerAdapter bMs;
    private ImageView bMt;
    private View bMu;
    private TextView bMv;
    private TextView bMw;
    private View mNoDataView;
    private View mRoot;
    private int bMx = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bMu && view == AlbumImageBrowseFragment.this.bMt && AlbumImageBrowseFragment.this.bMs != null && AlbumImageBrowseFragment.this.bMd != null && AlbumImageBrowseFragment.this.bMr != null) {
                if (AlbumImageBrowseFragment.this.bMd.WP()) {
                    AlbumImageBrowseFragment.this.bMr.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bMs.gu(AlbumImageBrowseFragment.this.bMx)) {
                    ImageFileInfo gt = AlbumImageBrowseFragment.this.bMs.gt(AlbumImageBrowseFragment.this.bMx);
                    if (AlbumImageBrowseFragment.this.bMd.isAdded(gt)) {
                        if (AlbumImageBrowseFragment.this.bMr.b(gt)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, false);
                            AlbumImageBrowseFragment.this.bMr.a(gt, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bMr.a(gt)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, true);
                        AlbumImageBrowseFragment.this.bMr.a(gt, true);
                    }
                    AlbumImageBrowseFragment.this.WC();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.bMx = i;
            if (AlbumImageBrowseFragment.this.bMs != null && AlbumImageBrowseFragment.this.bMd != null) {
                ImageFileInfo gt = AlbumImageBrowseFragment.this.bMs.gt(AlbumImageBrowseFragment.this.bMx);
                if (AlbumImageBrowseFragment.this.bMd.isAdded(gt)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bMt, false);
                }
                if (gt == null || !gt.isGif()) {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bMw.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dj(AlbumImageBrowseFragment.this.bMd.isOriginalImg());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMr = (AlbumActivity) getBaseFragmentActivity();
        this.bMd = this.bMr.Wz();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aHx = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bMt = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.Zk = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bMv = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bMw = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bMu = this.mRoot.findViewById(a.f.layout_bottom);
        this.aHx.setOnClickListener(this.bMr);
        this.bMv.setOnClickListener(this.bMr);
        this.bMt.setOnClickListener(this.mOnClickListener);
        this.bMw.setOnClickListener(this.bMr);
        this.bMu.setOnClickListener(this.mOnClickListener);
        this.Zk.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WC() {
        this.bMr.Ww();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            WE();
        }
    }

    private void WD() {
        List<ImageFileInfo> WU;
        int currentIndex;
        if (this.bMd == null && this.bMr != null) {
            this.bMd = this.bMr.Wz();
        }
        if (this.bMd != null && (WU = this.bMd.WU()) != null && (currentIndex = this.bMd.getCurrentIndex()) >= 0) {
            this.bMx = currentIndex;
            this.bMs = new AlbumImagePagerAdapter(this.bMr);
            this.Zk.setAdapter(this.bMs);
            if (this.bMx == 0 && WU != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(WU, this.bMx);
                if (this.bMd.isAdded(imageFileInfo)) {
                    a(this.bMt, true);
                } else {
                    a(this.bMt, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bMw.setVisibility(8);
                } else {
                    this.bMw.setVisibility(0);
                }
            }
            this.bMs.setData(WU);
            this.Zk.setCurrentItem(this.bMx, false);
            dj(this.bMd.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bMs != null) {
            this.bMs.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aHx, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bMd != null) {
            dj(this.bMd.isOriginalImg());
        }
        if (this.bMs != null) {
            this.bMs.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bMr != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bMv != null) {
                int count = this.bMd != null ? ListUtils.getCount(this.bMd.WR()) : 0;
                this.bMv.setText(this.bMr.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bMd != null ? this.bMd.getMaxImagesAllowed() : 1)}));
                this.bMv.setEnabled(count > 0);
            }
        }
    }

    private void WE() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Zk.setVisibility(0);
            WD();
        }
    }

    public void dj(boolean z) {
        long j;
        if (this.bMr != null && this.bMw != null) {
            if (this.bMs != null) {
                ImageFileInfo gt = this.bMs.gt(this.bMx);
                j = gt != null ? FileHelper.getFileSize(gt.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bMr.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bMw, a.c.sdk_cp_link_tip_a);
                this.bMw.setText(sb2);
                this.bMw.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bMw, a.c.sdk_cp_cont_f);
            this.bMw.setText(string);
            this.bMw.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
