package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class ao extends be {
    public static final BdUniqueId Py = BdUniqueId.gen();
    private List<PhotoLiveCardData> Pz;
    private int PA = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void p(List<PhotoLiveCardData> list) {
        this.Pz = list;
    }

    public void a(be beVar, int i) {
        if (beVar != null) {
            setAuthor(beVar.getAuthor());
            setTitle(beVar.getTitle());
            setPhotoLiveCover(beVar.getPhotoLiveCover());
            setForum_name(beVar.getForum_name());
            cr(beVar.getTid());
            p(beVar.qs());
            setAddress(beVar.getAddress());
            setId(beVar.getId());
            setThreadType(beVar.getThreadType());
            a(beVar.qp());
            bH(beVar.qr());
            setPost_num(beVar.getPost_num());
            cs(beVar.qD());
            cr(beVar.getTid());
            setExpressionDatas(beVar.qN());
            setShowExpressionViewIndexList(beVar.qN());
            setId(beVar.getId());
            this.RW = beVar.qQ();
            this.RX = beVar.qR();
            this.RY = beVar.qS();
            if (getShowStyle() < 0) {
                this.PA = getRandom(3, i);
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
            bH(zhiBoInfoTW.reply_num.intValue());
            setForum_name(zhiBoInfoTW.forum_name);
            setPhotoLiveCover(zhiBoInfoTW.livecover_src);
            p(zhiBoInfoTW.last_modified_time.longValue());
            setPost_num(zhiBoInfoTW.post_num.intValue());
            setTitle(zhiBoInfoTW.title);
            setShowExpressionViewIndexList(q(zhiBoInfoTW.labelInfo));
            this.PA = getRandom(3, i);
            cr(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            setForum_name(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.n> q(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
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

    public void setShowExpressionViewIndexList(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        int size = arrayList.size();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < size && i < 3) {
            if (arrayList.get(i) != null) {
                int random = getRandom(3, -1);
                if (random == i2 || random == i3) {
                    random = l(size, i2, i3);
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

    private int l(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    public int getShowStyle() {
        return this.PA;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Py;
    }
}
