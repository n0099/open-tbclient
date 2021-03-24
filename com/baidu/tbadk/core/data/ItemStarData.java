package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ListUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
/* loaded from: classes3.dex */
public class ItemStarData implements Serializable {
    public List<SingleItemStar> list;

    /* loaded from: classes3.dex */
    public class SingleItemStar implements Serializable {
        public String content;
        public String name;
        public int type;

        public SingleItemStar() {
        }

        public void parseProto(HeadItem headItem) {
            if (headItem == null) {
                return;
            }
            this.name = headItem.name;
            this.content = headItem.content;
            this.type = headItem.type.intValue();
        }
    }

    public void parseProto(List<HeadItem> list) {
        if (ListUtils.getCount(list) == 0) {
            return;
        }
        this.list = new ArrayList();
        for (HeadItem headItem : list) {
            if (headItem != null) {
                SingleItemStar singleItemStar = new SingleItemStar();
                singleItemStar.parseProto(headItem);
                this.list.add(singleItemStar);
            }
        }
    }
}
