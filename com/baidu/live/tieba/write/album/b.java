package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private String bLD;
    private int bLE;
    private AlbumActivity bLp;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.bLp = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.bLp.getPageContext().getPageActivity());
        this.bLE = BdUtilHelper.getEquipmentWidth(this.bLp.getPageContext().getPageActivity()) / 2;
    }

    public void setData(List<AlbumData> list, String str) {
        this.mList = list;
        this.bLD = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eS */
    public AlbumData getItem(int i) {
        return (AlbumData) ListUtils.getItem(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = this.mLayoutInflater.inflate(a.g.sdk_ph_album_list_item, viewGroup, false);
            aVar = new a();
            aVar.bLF = (TbImageView) view.findViewById(a.f.item_head);
            aVar.bLG = (TextView) view.findViewById(a.f.item_name);
            aVar.bLH = (ImageView) view.findViewById(a.f.item_arrow);
            aVar.bLF.setGifIconSupport(false);
            aVar.bLF.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bLG.setText(BdUtilHelper.getTextOmit(aVar.bLG.getPaint(), item.getName(), this.bLE) + "(" + item.getCount() + ")");
            } else {
                aVar.bLG.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bLD)) {
                SkinManager.setImageResource(aVar.bLH, a.e.sdk_ph_icon_list_select_ok_n);
                aVar.bLH.setVisibility(0);
            } else {
                aVar.bLH.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.bLF.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.bLF.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.bLG, a.c.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.e.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class a {
        TbImageView bLF;
        TextView bLG;
        ImageView bLH;

        private a() {
        }
    }
}
