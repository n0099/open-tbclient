package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class EvaluateRelevanceItemSelectedMessage extends CustomResponsedMessage<Object> {
    public double icon_size;
    public String icon_url;
    public String item_id;
    public String item_name;
    public double score;
    public int star;
    public List<String> tags;

    public EvaluateRelevanceItemSelectedMessage(String str, String str2, String str3, double d2, double d3, int i2, List<String> list) {
        super(2921516);
        this.item_id = str;
        this.item_name = str2;
        this.icon_url = str3;
        this.score = d2;
        this.icon_size = d3;
        this.star = i2;
        this.tags = list;
    }
}
