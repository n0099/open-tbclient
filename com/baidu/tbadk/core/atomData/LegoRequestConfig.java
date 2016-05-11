package com.baidu.tbadk.core.atomData;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LegoRequestConfig extends IntentConfig {
    public static final int TYPE_GET_BASE_CARD_VIEW = 3;
    public static final int TYPE_GET_CARD_INFO = 1;
    public static final int TYPE_GET_CARD_TYPE = 5;
    public static final int TYPE_GET_VIEW_ITEMS = 2;
    public static final int TYPE_UPDATE = 4;
    private int businessType;
    private String card;
    private Object cardInfo;
    private Object cardView;
    private int requestType;
    private TbPageContext tbPageContext;

    public String getCard() {
        return this.card;
    }

    public void setCard(String str) {
        this.card = str;
    }

    public Object getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(Object obj) {
        this.cardInfo = obj;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(int i) {
        this.businessType = i;
    }

    public TbPageContext getTbPageContext() {
        return this.tbPageContext;
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.tbPageContext = tbPageContext;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public Object getCardView() {
        return this.cardView;
    }

    public void setCardView(Object obj) {
        this.cardView = obj;
    }
}
