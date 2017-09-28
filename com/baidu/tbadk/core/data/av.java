package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tbclient.LabelInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class av extends bh {
    public static final BdUniqueId XF = BdUniqueId.gen();
    private List<PhotoLiveCardData> XG;
    private int XH = 0;
    private ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

    public void q(List<PhotoLiveCardData> list) {
        this.XG = list;
    }

    public void a(bh bhVar, int i) {
        if (bhVar != null) {
            setAuthor(bhVar.getAuthor());
            setTitle(bhVar.getTitle());
            setPhotoLiveCover(bhVar.getPhotoLiveCover());
            cC(bhVar.rA());
            cy(bhVar.getTid());
            l(bhVar.rp());
            setAddress(bhVar.getAddress());
            setId(bhVar.getId());
            setThreadType(bhVar.getThreadType());
            a(bhVar.rl());
            bS(bhVar.rn());
            setPost_num(bhVar.getPost_num());
            cD(bhVar.rD());
            cy(bhVar.getTid());
            setExpressionDatas(bhVar.rO());
            setShowExpressionViewIndexList(bhVar.rO());
            setId(bhVar.getId());
            a(bhVar.qm());
            this.ZK = bhVar.rR();
            this.ZL = bhVar.rS();
            this.ZM = bhVar.rT();
            if (getShowStyle() < 0) {
                this.XH = getRandom(3, i);
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
            cD(zhiBoInfoTW.content);
            setFid(zhiBoInfoTW.forum_id.longValue());
            setExpressionDatas(r(zhiBoInfoTW.labelInfo));
            bS(zhiBoInfoTW.reply_num.intValue());
            cC(zhiBoInfoTW.forum_name);
            setPhotoLiveCover(zhiBoInfoTW.livecover_src);
            l(zhiBoInfoTW.last_modified_time.longValue());
            setPost_num(zhiBoInfoTW.post_num.intValue());
            setTitle(zhiBoInfoTW.title);
            setShowExpressionViewIndexList(r(zhiBoInfoTW.labelInfo));
            this.XH = getRandom(3, i);
            cy(String.valueOf(zhiBoInfoTW.thread_id));
            setId(String.valueOf(zhiBoInfoTW.thread_id));
            setThreadType(33);
            cC(zhiBoInfoTW.forum_name);
        }
    }

    private ArrayList<com.baidu.tbadk.coreExtra.view.e> r(List<LabelInfo> list) {
        ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LabelInfo labelInfo = list.get(i);
            if (labelInfo != null) {
                com.baidu.tbadk.coreExtra.view.e eVar = new com.baidu.tbadk.coreExtra.view.e();
                eVar.ev(labelInfo.labelHot.intValue());
                eVar.setLabelId(labelInfo.labelId);
                eVar.setLabelName(labelInfo.labelContent);
                arrayList.add(eVar);
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

    public void setShowExpressionViewIndexList(ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList) {
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
        return this.XH;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XF;
    }
}
