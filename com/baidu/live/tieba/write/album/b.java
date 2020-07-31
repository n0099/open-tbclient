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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private AlbumActivity bjd;
    private String bjq;
    private int bjr;
    private LayoutInflater mLayoutInflater;
    private List<AlbumData> mList;

    public b(AlbumActivity albumActivity) {
        this.bjd = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.bjd.getPageContext().getPageActivity());
        this.bjr = BdUtilHelper.getEquipmentWidth(this.bjd.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<AlbumData> list, String str) {
        this.mList = list;
        this.bjq = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dx */
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
            aVar.bjs = (TbImageView) view.findViewById(a.g.item_head);
            aVar.bjt = (TextView) view.findViewById(a.g.item_name);
            aVar.bju = (ImageView) view.findViewById(a.g.item_arrow);
            aVar.bjs.setGifIconSupport(false);
            aVar.bjs.setLongIconSupport(false);
            view.setTag(aVar);
        }
        AlbumData item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bjt.setText(BdUtilHelper.getTextOmit(aVar.bjt.getPaint(), item.getName(), this.bjr) + "(" + item.getCount() + ")");
            } else {
                aVar.bjt.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bjq)) {
                SkinManager.setImageResource(aVar.bju, a.f.sdk_ph_icon_list_select_ok_n);
                aVar.bju.setVisibility(0);
            } else {
                aVar.bju.setVisibility(8);
            }
            MediaFileInfo mediaFileInfo = item.getMediaFileInfo();
            if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.bjs.startLoad(TbImageView.getUrlWithResizeTag(((VideoFileInfo) mediaFileInfo).videoPath, 200, 200), 37, false);
            } else if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.bjs.startLoad(TbImageView.getUrlWithResizeTag(((ImageFileInfo) mediaFileInfo).getFilePath(), 200, 200), 35, false);
            }
            SkinManager.setViewTextColor(aVar.bjt, a.d.sdk_cp_cont_b);
            SkinManager.setBackgroundResource(view, a.f.sdk_ph_addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class a {
        TbImageView bjs;
        TextView bjt;
        ImageView bju;

        private a() {
        }
    }
}
