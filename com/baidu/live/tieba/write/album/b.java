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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private AlbumActivity bHF;
    private String bHT;
    private int bHU;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.bHF = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.bHF.getPageContext().getPageActivity());
        this.bHU = BdUtilHelper.getEquipmentWidth(this.bHF.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<AlbumData> list, String str) {
        this.mList = list;
        this.bHT = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eO */
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
            aVar.bHV = (TbImageView) view.findViewById(a.f.item_head);
            aVar.bHW = (TextView) view.findViewById(a.f.item_name);
            aVar.bHX = (ImageView) view.findViewById(a.f.item_arrow);
            aVar.bHV.setGifIconSupport(false);
            aVar.bHV.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bHW.setText(BdUtilHelper.getTextOmit(aVar.bHW.getPaint(), item.getName(), this.bHU) + "(" + item.getCount() + ")");
            } else {
                aVar.bHW.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bHT)) {
                SkinManager.setImageResource(aVar.bHX, a.e.sdk_ph_icon_list_select_ok_n);
                aVar.bHX.setVisibility(0);
            } else {
                aVar.bHX.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.bHV.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.bHV.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.bHW, a.c.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.e.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class a {
        TbImageView bHV;
        TextView bHW;
        ImageView bHX;

        private a() {
        }
    }
}
