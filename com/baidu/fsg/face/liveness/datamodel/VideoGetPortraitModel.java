package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.tbadk.core.util.StringHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoGetPortraitModel implements IBeanResponse, Serializable {
    public String cutTimePoints;
    public String display_name;
    public String guideContent;
    public String guideTitle;
    public String readingContent;
    public String readingContentId;
    public String videoMaxSize;

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public long[] getCutTimePoints() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.cutTimePoints)) {
            String[] split = this.cutTimePoints.split(",");
            if (split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(str)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        return jArr;
    }

    public List<String> getLrcContent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(StringHelper.STRING_MORE);
        if (!TextUtils.isEmpty(this.readingContent)) {
            arrayList.addAll(Arrays.asList(this.readingContent.split("\\|")));
        }
        arrayList.add(" ");
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getVideoMaxSize() {
        int i;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.videoMaxSize)) {
            i = Integer.parseInt(this.videoMaxSize);
            if (i <= 0) {
                return i;
            }
            return Integer.MAX_VALUE;
        }
        i = Integer.MAX_VALUE;
        if (i <= 0) {
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
