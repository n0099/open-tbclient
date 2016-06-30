package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.coreExtra.view.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class aj extends az {
    public static final BdUniqueId Pc = BdUniqueId.gen();
    private List<PhotoLiveCardData> Pd;
    private int Pe = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void p(List<PhotoLiveCardData> list) {
        this.Pd = list;
    }

    public void a(az azVar, int i) {
        if (azVar != null) {
            setAuthor(azVar.getAuthor());
            setTitle(azVar.getTitle());
            setPhotoLiveCover(azVar.getPhotoLiveCover());
            setForum_name(azVar.getForum_name());
            cr(azVar.getTid());
            u(azVar.getLast_time_int());
            setAddress(azVar.getAddress());
            setId(azVar.getId());
            setThreadType(azVar.getThreadType());
            setPraise(azVar.getPraise());
            setReply_num(azVar.getReply_num());
            setPost_num(azVar.getPost_num());
            cs(azVar.qO());
            cr(azVar.getTid());
            setExpressionDatas(azVar.qX());
            setShowExpressionViewIndexList(azVar.qX());
            setId(azVar.getId());
            if (getShowStyle() < 0) {
                this.Pe = getRandom(3, i);
            }
        }
    }

    public void a(ZhiBoInfoTW zhiBoInfoTW, int i) {
        if (zhiBoInfoTW != null) {
            if (zhiBoInfoTW.user != null) {
                MetaData metaData = new MetaData();
                metaData.setUserId(String.valueOf(zhiBoInfoTW.user.id));
                metaData.setUserName(zhiBoInfoTW.user.name);
                metaData.setPortrait(zhiBoInfoTW.user.portrait);
                metaData.setFansNickName(zhiBoInfoTW.user.fans_nickname);
                metaData.setFansNum(zhiBoInfoTW.user.fans_num.intValue());
                setAuthor(metaData);
            }
            cs(zhiBoInfoTW.content);
            setFid(zhiBoInfoTW.forum_id.longValue());
            setExpressionDatas(q(zhiBoInfoTW.labelInfo));
            setReply_num(zhiBoInfoTW.reply_num.intValue());
            setForum_name(zhiBoInfoTW.forum_name);
            setPhotoLiveCover(zhiBoInfoTW.livecover_src);
            u(zhiBoInfoTW.last_modified_time.longValue());
            setPost_num(zhiBoInfoTW.post_num.intValue());
            setTitle(zhiBoInfoTW.title);
            setShowExpressionViewIndexList(q(zhiBoInfoTW.labelInfo));
            this.Pe = getRandom(3, i);
            cr(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            setForum_name(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<n> q(List<LabelInfo> list) {
        ArrayList<n> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                n nVar = new n();
                nVar.dR(labelInfo.labelHot.intValue());
                nVar.setLabelId(labelInfo.labelId);
                nVar.setLabelName(labelInfo.labelContent);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public int getRandom(int i, int i2) {
        int nextInt = new Random().nextInt(i);
        if (nextInt == i2) {
            return (nextInt + 1) % i;
        }
        return nextInt;
    }

    public void setShowExpressionViewIndexList(ArrayList<n> arrayList) {
        int size = arrayList.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < size && i < 3) {
            if (arrayList.get(i) != null) {
                int random = getRandom(3, -1);
                if (random == i2 || random == i3) {
                    random = k(size, i2, i3);
                }
                if (i == 0) {
                    i2 = random;
                }
                if (i == 1) {
                    i3 = random;
                }
                this.showExpressionViewIndex.add(Integer.valueOf(random));
            }
            i++;
            i2 = i2;
        }
    }

    public ArrayList<Integer> getShowExpressionViewIndex() {
        return this.showExpressionViewIndex;
    }

    private int k(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    public int getShowStyle() {
        return this.Pe;
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pc;
    }
}
