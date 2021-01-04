package com.baidu.live.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    private Map<Integer, Boolean> bME = new HashMap();
    private AlbumActivity bMr;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mList;

    public AlbumImagePagerAdapter(AlbumActivity albumActivity) {
        this.bMr = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.bMr.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo gt(int i) {
        return (ImageFileInfo) ListUtils.getItem(this.mList, i);
    }

    public boolean gu(int i) {
        if (this.bME.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.bME.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(a.g.sdk_ph_album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.thumbnail_iamge);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        ImageFileInfo gt = gt(i);
        if (gt != null) {
            tbImageView.startLoad(gt.getFilePath(), 35, false, false);
            this.bME.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        SkinManager.setBackgroundColor(inflate, a.c.sdk_cp_bg_line_d);
        return inflate;
    }
}
