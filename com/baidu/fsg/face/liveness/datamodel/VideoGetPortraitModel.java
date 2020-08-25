package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes11.dex */
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

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public long[] getCutTimePoints() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.cutTimePoints)) {
            String[] split = this.cutTimePoints.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(str)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        long[] jArr = new long[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                jArr[i2] = ((Long) arrayList.get(i2)).longValue();
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    public List<String> getLrcContent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(StringHelper.STRING_MORE);
        if (!TextUtils.isEmpty(this.readingContent)) {
            arrayList.addAll(Arrays.asList(this.readingContent.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR)));
        }
        arrayList.add(" ");
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getVideoMaxSize() {
        int i;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.videoMaxSize)) {
            i = Integer.parseInt(this.videoMaxSize);
            return i <= 0 ? i : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        i = Integer.MAX_VALUE;
        if (i <= 0) {
        }
    }
}
