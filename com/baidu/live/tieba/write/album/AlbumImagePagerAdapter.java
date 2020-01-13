package com.baidu.live.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    private AlbumActivity axQ;
    private Map<Integer, Boolean> aya = new HashMap();
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mList;

    public AlbumImagePagerAdapter(AlbumActivity albumActivity) {
        this.axQ = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.axQ.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo cz(int i) {
        return (ImageFileInfo) ListUtils.getItem(this.mList, i);
    }

    public boolean cA(int i) {
        if (this.aya.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.aya.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(a.h.sdk_ph_album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.thumbnail_iamge);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        ImageFileInfo cz = cz(i);
        if (cz != null) {
            tbImageView.startLoad(cz.getFilePath(), 35, false, true);
            this.aya.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        SkinManager.setBackgroundColor(inflate, a.d.sdk_cp_bg_line_d);
        return inflate;
    }
}
