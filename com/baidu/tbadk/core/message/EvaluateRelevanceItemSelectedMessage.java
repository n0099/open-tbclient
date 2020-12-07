package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class EvaluateRelevanceItemSelectedMessage extends CustomResponsedMessage<Object> {
    public double icon_size;
    public String icon_url;
    public String item_id;
    public String item_name;
    public double score;
    public int star;
    public List<String> tags;

    public EvaluateRelevanceItemSelectedMessage(String str, String str2, String str3, double d, double d2, int i, List<String> list) {
        super(2921516);
        this.item_id = str;
        this.item_name = str2;
        this.icon_url = str3;
        this.score = d;
        this.icon_size = d2;
        this.star = i;
        this.tags = list;
    }
}
