package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.ForumData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import protobuf.ForumRalatedInfo;
import protobuf.GetLivableForumList.DataRes;
import protobuf.GetLivableForumList.GetLivableForumListResIdl;
/* loaded from: classes3.dex */
public class ResponseGetLivableForumList extends SocketResponsedMessage {
    public boolean available;
    public ArrayList<ForumData> data;
    public boolean hasMore;
    public int minLevel;
    public String tips;

    public ResponseGetLivableForumList() {
        super(107129);
        this.available = false;
        this.data = new ArrayList<>();
    }

    public boolean getAvailabel() {
        return this.available;
    }

    public ArrayList<ForumData> getData() {
        return this.data;
    }

    public int getMiniLevel() {
        return this.minLevel;
    }

    public String getTips() {
        return this.tips;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setAvailabel(int i) {
        if (i == 1) {
            this.available = true;
        } else {
            this.available = false;
        }
    }

    public void setData(List<ForumRalatedInfo> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    ForumData forumData = new ForumData();
                    forumData.setCurScore(list.get(i).curScore.intValue());
                    forumData.setImage_url(list.get(i).avatar);
                    forumData.setLevelupScore(list.get(i).leftScore.intValue());
                    forumData.setUser_level(list.get(i).level.intValue());
                    forumData.setName(list.get(i).name);
                    forumData.setId(list.get(i).forumId.toString());
                    this.data.add(forumData);
                }
            }
        }
    }

    public void setHasMore(int i) {
        if (i == 1) {
            this.hasMore = true;
        } else {
            this.hasMore = false;
        }
    }

    public void setMiniLevel(int i) {
        this.minLevel = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetLivableForumListResIdl getLivableForumListResIdl = (GetLivableForumListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLivableForumListResIdl.class);
        setError(getLivableForumListResIdl.error.errorno.intValue());
        setErrorString(getLivableForumListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        DataRes dataRes = getLivableForumListResIdl.data;
        this.tips = dataRes.tips;
        setHasMore(dataRes.hasMore.intValue());
        setAvailabel(getLivableForumListResIdl.data.available.intValue());
        setData(getLivableForumListResIdl.data.likeList);
        setMiniLevel(getLivableForumListResIdl.data.minLevel.intValue());
    }
}
