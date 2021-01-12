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
/* loaded from: classes10.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    private ViewPager Zi;
    private ImageView aCK;
    private AlbumActivity bHF;
    private AlbumImagePagerAdapter bHG;
    private ImageView bHH;
    private View bHI;
    private TextView bHJ;
    private TextView bHK;
    private c bHr;
    private View mNoDataView;
    private View mRoot;
    private int bHL = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != AlbumImageBrowseFragment.this.bHI && view == AlbumImageBrowseFragment.this.bHH && AlbumImageBrowseFragment.this.bHG != null && AlbumImageBrowseFragment.this.bHr != null && AlbumImageBrowseFragment.this.bHF != null) {
                if (AlbumImageBrowseFragment.this.bHr.SX()) {
                    AlbumImageBrowseFragment.this.bHF.showToast(a.h.sdk_ph_album_choose_switch_tip);
                } else if (AlbumImageBrowseFragment.this.bHG.eN(AlbumImageBrowseFragment.this.bHL)) {
                    ImageFileInfo eM = AlbumImageBrowseFragment.this.bHG.eM(AlbumImageBrowseFragment.this.bHL);
                    if (AlbumImageBrowseFragment.this.bHr.isAdded(eM)) {
                        if (AlbumImageBrowseFragment.this.bHF.b(eM)) {
                            AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, false);
                            AlbumImageBrowseFragment.this.bHF.a(eM, false);
                        }
                    } else if (AlbumImageBrowseFragment.this.bHF.a(eM)) {
                        AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, true);
                        AlbumImageBrowseFragment.this.bHF.a(eM, true);
                    }
                    AlbumImageBrowseFragment.this.SK();
                }
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tieba.write.album.AlbumImageBrowseFragment.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.bHL = i;
            if (AlbumImageBrowseFragment.this.bHG != null && AlbumImageBrowseFragment.this.bHr != null) {
                ImageFileInfo eM = AlbumImageBrowseFragment.this.bHG.eM(AlbumImageBrowseFragment.this.bHL);
                if (AlbumImageBrowseFragment.this.bHr.isAdded(eM)) {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, true);
                } else {
                    AlbumImageBrowseFragment.this.a(AlbumImageBrowseFragment.this.bHH, false);
                }
                if (eM == null || !eM.isGif()) {
                    AlbumImageBrowseFragment.this.bHK.setVisibility(0);
                } else {
                    AlbumImageBrowseFragment.this.bHK.setVisibility(8);
                }
                AlbumImageBrowseFragment.this.df(AlbumImageBrowseFragment.this.bHr.isOriginalImg());
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
        this.bHF = (AlbumActivity) getBaseFragmentActivity();
        this.bHr = this.bHF.SH();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRoot = layoutInflater.inflate(a.g.sdk_ph_album_big_image_view, (ViewGroup) null);
        this.aCK = (ImageView) this.mRoot.findViewById(a.f.img_back);
        this.bHH = (ImageView) this.mRoot.findViewById(a.f.img_choose);
        this.Zi = (ViewPager) this.mRoot.findViewById(a.f.viewPager);
        this.mNoDataView = this.mRoot.findViewById(a.f.album_no_data);
        this.bHJ = (TextView) this.mRoot.findViewById(a.f.btn_next_step);
        this.bHK = (TextView) this.mRoot.findViewById(a.f.original_select_btn);
        this.bHI = this.mRoot.findViewById(a.f.layout_bottom);
        this.aCK.setOnClickListener(this.bHF);
        this.bHJ.setOnClickListener(this.bHF);
        this.bHH.setOnClickListener(this.mOnClickListener);
        this.bHK.setOnClickListener(this.bHF);
        this.bHI.setOnClickListener(this.mOnClickListener);
        this.Zi.setOnPageChangeListener(this.mOnPageChangeListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        this.bHF.SE();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            SM();
        }
    }

    private void SL() {
        List<ImageFileInfo> Tc;
        int currentIndex;
        if (this.bHr == null && this.bHF != null) {
            this.bHr = this.bHF.SH();
        }
        if (this.bHr != null && (Tc = this.bHr.Tc()) != null && (currentIndex = this.bHr.getCurrentIndex()) >= 0) {
            this.bHL = currentIndex;
            this.bHG = new AlbumImagePagerAdapter(this.bHF);
            this.Zi.setAdapter(this.bHG);
            if (this.bHL == 0 && Tc != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(Tc, this.bHL);
                if (this.bHr.isAdded(imageFileInfo)) {
                    a(this.bHH, true);
                } else {
                    a(this.bHH, false);
                }
                if (imageFileInfo.isGif()) {
                    this.bHK.setVisibility(8);
                } else {
                    this.bHK.setVisibility(0);
                }
            }
            this.bHG.setData(Tc);
            this.Zi.setCurrentItem(this.bHL, false);
            df(this.bHr.isOriginalImg());
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.bHG != null) {
            this.bHG.setData(null);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinUtil.onModeChanged(getPageContext(), this.mRoot);
        SkinManager.setNavbarIconSrc(this.aCK, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg, i);
        if (this.bHr != null) {
            df(this.bHr.isOriginalImg());
        }
        if (this.bHG != null) {
            this.bHG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null && this.bHF != null) {
            SkinManager.setImageResource(imageView, z ? a.e.sdk_ph_ic_post_edit_select_s : a.e.sdk_ph_icon_image_clear_select);
            if (this.bHJ != null) {
                int count = this.bHr != null ? ListUtils.getCount(this.bHr.SZ()) : 0;
                this.bHJ.setText(this.bHF.getString(a.h.sdk_ph_image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(this.bHr != null ? this.bHr.getMaxImagesAllowed() : 1)}));
                this.bHJ.setEnabled(count > 0);
            }
        }
    }

    private void SM() {
        if (!isHidden()) {
            this.mNoDataView.setVisibility(8);
            this.Zi.setVisibility(0);
            SL();
        }
    }

    public void df(boolean z) {
        long j;
        if (this.bHF != null && this.bHK != null) {
            if (this.bHG != null) {
                ImageFileInfo eM = this.bHG.eM(this.bHL);
                j = eM != null ? FileHelper.getFileSize(eM.getFilePath()) : 0L;
            } else {
                j = 0;
            }
            String string = this.bHF.getResources().getString(a.h.sdk_ph_original_img);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(")");
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_link_tip_a);
                this.bHK.setText(sb2);
                this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_ok_n), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.bHK, a.c.sdk_cp_cont_f);
            this.bHK.setText(string);
            this.bHK.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.e.sdk_ph_icon_image_select_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }
}
