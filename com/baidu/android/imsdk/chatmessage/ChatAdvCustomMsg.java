package com.baidu.android.imsdk.chatmessage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ChatAdvCustomMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String aid;
    public int allowRefund;
    public String cardTip;
    public int evaAmount;
    public boolean evaHasRefund;
    public int evaIsEvaluated;
    public int evaIsFree;
    public String evaMsg;
    public String evaStarDesc;
    public int evaStarNum;
    public String evaSubTitle;
    public List<String> evaTagList;
    public List<String> evaTags;
    public String evaTitle;
    public int evaType;
    public int orderType;
    public int refundStatus;
    public String refundText;
    public String refundTitle;
    public String refundUrlText;
    public String replyerUid;
    public int role;
    public List<String> sopList;
    public String sopTitle;
    public int source;
    public long targetMsgId;
    public String uk;

    public ChatAdvCustomMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.evaTags = new ArrayList();
        this.evaTagList = new ArrayList();
    }

    public ChatAdvCustomMsg(long j, int i, String str, String str2, int i2, String str3, String str4, int i3, int i4, String str5, String str6, List<String> list, List<String> list2, int i5, int i6, boolean z, int i7, String str7, String str8, int i8, int i9, String str9, int i10, String str10, String str11, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), str5, str6, list, list2, Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i7), str7, str8, Integer.valueOf(i8), Integer.valueOf(i9), str9, Integer.valueOf(i10), str10, str11, list3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i11 = newInitContext.flag;
            if ((i11 & 1) != 0) {
                int i12 = i11 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.evaTags = new ArrayList();
        this.evaTagList = new ArrayList();
        this.targetMsgId = j;
        this.role = i;
        this.aid = str;
        this.uk = str2;
        this.evaType = i2;
        this.evaTitle = str3;
        this.evaSubTitle = str4;
        this.evaIsEvaluated = i3;
        this.evaStarNum = i4;
        this.evaStarDesc = str5;
        this.evaMsg = str6;
        this.evaTags = list;
        this.evaTagList = list2;
        this.evaAmount = i5;
        this.evaIsFree = i6;
        this.evaHasRefund = z;
        this.refundStatus = i7;
        this.refundTitle = str7;
        this.refundText = str8;
        this.source = i8;
        this.orderType = i9;
        this.replyerUid = str9;
        this.allowRefund = i10;
        this.cardTip = str10;
        this.sopTitle = str11;
        this.sopList = list3;
    }

    public ChatAdvCustomMsg(long j, int i, String str, String str2, int i2, String str3, String str4, int i3, int i4, String str5, String str6, List<String> list, List<String> list2, int i5, int i6, boolean z, int i7, String str7, String str8, String str9, int i8, int i9, String str10, int i10, String str11, String str12, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, str4, Integer.valueOf(i3), Integer.valueOf(i4), str5, str6, list, list2, Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i7), str7, str8, str9, Integer.valueOf(i8), Integer.valueOf(i9), str10, Integer.valueOf(i10), str11, str12, list3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i11 = newInitContext.flag;
            if ((i11 & 1) != 0) {
                int i12 = i11 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.evaTags = new ArrayList();
        this.evaTagList = new ArrayList();
        this.targetMsgId = j;
        this.role = i;
        this.aid = str;
        this.uk = str2;
        this.evaType = i2;
        this.evaTitle = str3;
        this.evaSubTitle = str4;
        this.evaIsEvaluated = i3;
        this.evaStarNum = i4;
        this.evaStarDesc = str5;
        this.evaMsg = str6;
        this.evaTags = list;
        this.evaTagList = list2;
        this.evaAmount = i5;
        this.evaIsFree = i6;
        this.evaHasRefund = z;
        this.refundStatus = i7;
        this.refundTitle = str7;
        this.refundText = str8;
        this.refundUrlText = str9;
        this.source = i8;
        this.orderType = i9;
        this.replyerUid = str10;
        this.allowRefund = i10;
        this.cardTip = str11;
        this.sopTitle = str12;
        this.sopList = list3;
    }
}
