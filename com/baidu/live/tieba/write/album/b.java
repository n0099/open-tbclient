package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String aCH;
    private int aCI;
    private AlbumActivity aCw;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.aCw = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.aCw.getPageContext().getPageActivity());
        this.aCI = BdUtilHelper.getEquipmentWidth(this.aCw.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<AlbumData> list, String str) {
        this.mList = list;
        this.aCH = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cR */
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
            view = this.mLayoutInflater.inflate(a.h.sdk_ph_album_list_item, viewGroup, false);
            aVar = new a();
            aVar.aCJ = (TbImageView) view.findViewById(a.g.item_head);
            aVar.aCK = (TextView) view.findViewById(a.g.item_name);
            aVar.aCL = (ImageView) view.findViewById(a.g.item_arrow);
            aVar.aCJ.setGifIconSupport(false);
            aVar.aCJ.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.aCK.setText(BdUtilHelper.getTextOmit(aVar.aCK.getPaint(), item.getName(), this.aCI) + "(" + item.getCount() + ")");
            } else {
                aVar.aCK.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aCH)) {
                SkinManager.setImageResource(aVar.aCL, a.f.sdk_ph_icon_list_select_ok_n);
                aVar.aCL.setVisibility(0);
            } else {
                aVar.aCL.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.aCJ.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.aCJ.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.aCK, a.d.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.f.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TbImageView aCJ;
        TextView aCK;
        ImageView aCL;

        private a() {
        }
    }
}
