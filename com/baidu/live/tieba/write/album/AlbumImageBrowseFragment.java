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
    private ViewPager Ze;
    private ImageView aEx;
    private c bLb;
    private AlbumActivity bLp;
    private AlbumImagePagerAdapter bLq;
    private ImageView bLr;
    private View bLs;
    private TextView bLt;
    private TextView bLu;
    private View mNoDataView;
    private View mRoot;
    private int bLv = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bLs && view == AlbumImageBrowseFragment.this.bLr && AlbumImageBrowseFragment.this.bLq != null && AlbumImageBrowseFragment.this.bLb != null && AlbumImageBrowseFragment.this.bLp != null) {
                if (AlbumImageBrowseFragment.this.bLb.UE()) {
                    AlbumImageBrowseFragment.this.bLp.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bLq.eR(AlbumImageBrowseFragment.this.bLv)) {
                    ImageFileInfo eQ = AlbumImageBrowseFragment.this.bLq.eQ(AlbumImageBrowseFragment.this.bLv);
                    if (AlbumImageBrowseFragment.this.bLb.isAdded(eQ)) {
                        if (AlbumImageBrowseFragment.this.bLp.b(eQ)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, false);
                            AlbumImageBrowseFragment.this.bLp.a(eQ, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bLp.a(eQ)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, true);
                        AlbumImageBrowseFragment.this.bLp.a(eQ, true);
                    }
                    AlbumImageBrowseFragment.this.Ur();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.bLv = i;
            if (AlbumImageBrowseFragment.this.bLq != null && AlbumImageBrowseFragment.this.bLb != null) {
                ImageFileInfo eQ = AlbumImageBrowseFragment.this.bLq.eQ(AlbumImageBrowseFragment.this.bLv);
                if (AlbumImageBrowseFragment.this.bLb.isAdded(eQ)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bLr, false);
                }
                if (eQ == null || !eQ.isGif()) {
                    AlbumImageBrowseFragment.this.bLu.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bLu.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.dn(AlbumImageBrowseFragment.this.bLb.isOriginalImg());
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
        this.bLp = (AlbumActivity) getBaseFragmentActivity();
        this.bLb = this.bLp.Uo();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aEx = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bLr = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.Ze = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bLt = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bLu = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bLs = this.mRoot.findViewById(a.f.layout_bottom);
        this.aEx.setOnClickListener(this.bLp);
        this.bLt.setOnClickListener(this.bLp);
        this.bLr.setOnClickListener(this.mOnClickListener);
        this.bLu.setOnClickListener(this.bLp);
        this.bLs.setOnClickListener(this.mOnClickListener);
        this.Ze.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        this.bLp.Ul();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            Ut();
        }
    }

    private void Us() {
        List<ImageFileInfo> UJ;
        int currentIndex;
        if (this.bLb == null && this.bLp != null) {
            this.bLb = this.bLp.Uo();
        }
        if (this.bLb != null && (UJ = this.bLb.UJ()) != null && (currentIndex = this.bLb.getCurrentIndex()) >= 0) {
            this.bLv = currentIndex;
            this.bLq = new AlbumImagePagerAdapter(this.bLp);
            this.Ze.setAdapter(this.bLq);
            if (this.bLv == 0 && UJ != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(UJ, this.bLv);
                if (this.bLb.isAdded(imageFileInfo)) {
                    a(this.bLr, true);
                } else {
                    a(this.bLr, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bLu.setVisibility(8);
                } else {
                    this.bLu.setVisibility(0);
                }
            }
            this.bLq.setData(UJ);
            this.Ze.setCurrentItem(this.bLv, false);
            dn(this.bLb.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bLq != null) {
            this.bLq.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aEx, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bLb != null) {
            dn(this.bLb.isOriginalImg());
        }
        if (this.bLq != null) {
            this.bLq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bLp != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bLt != null) {
                int count = this.bLb != null ? ListUtils.getCount(this.bLb.UG()) : 0;
                this.bLt.setText(this.bLp.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bLb != null ? this.bLb.getMaxImagesAllowed() : 1)}));
                this.bLt.setEnabled(count > 0);
            }
        }
    }

    private void Ut() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Ze.setVisibility(0);
            Us();
        }
    }

    public void dn(boolean z) {
        long j;
        if (this.bLp != null && this.bLu != null) {
            if (this.bLq != null) {
                ImageFileInfo eQ = this.bLq.eQ(this.bLv);
                j = eQ != null ? FileHelper.getFileSize(eQ.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bLp.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_link_tip_a);
                this.bLu.setText(sb2);
                this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bLu, a.c.sdk_cp_cont_f);
            this.bLu.setText(string);
            this.bLu.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
