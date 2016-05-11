package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class SubPbActivityConfig extends IntentConfig {
    public static final String ICON_LIST = "icon_list";
    public static final String KEY_ANTI = "anti";
    public static final String KEY_IMG_URLS = "img_urls";
    public static final String KEY_IS_JUMP_FROM_PB = "is_jump_from_pb";
    public static final String KEY_IS_SHOW_GO_TO_SUBJECT = "is_show_go_to_subject";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_REPLAY_NAME = "replay_name";
    public static final String KEY_REPLAY_POST_ID = "replay_post_id";
    public static final String KEY_SHOW_KEYBOARD = "show_keyboard";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_TAIL = "post_tail";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_USER_IDENTITY = "user_identity";
    public static final String SUB_KEY_IMG_CDN = "sub_img_cdn";
    public static final String SUB_KEY_IMG_OFFSET = "sub_img_offset";
    public static final String SUB_KEY_IMG_SRC = "sub_img_src";
    public static final String SUB_KEY_IMG_URL = "sub_img_url";

    public SubPbActivityConfig(Context context) {
        super(context);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, boolean z2) {
        return createSubPbActivityConfig(str, str2, str3, z, null, false, null, 0, null, null, z2);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z) {
        return createSubPbActivityConfig(str, str2, str3, z, null, false);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        return createSubPbActivityConfig(str, str2, str3, z, str4, z2, null, 0);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i) {
        return createSubPbActivityConfig(str, str2, str3, z, str4, z2, str5, i, null);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i, SmallTailInfo smallTailInfo) {
        return createSubPbActivityConfig(str, str2, str3, z, str4, z2, str5, i, null, null, false);
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i, SmallTailInfo smallTailInfo, AntiData antiData, boolean z3) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra(KEY_IS_JUMP_FROM_PB, z);
        intent.putExtra(KEY_SHOW_KEYBOARD, z2);
        intent.putExtra(KEY_REPLAY_NAME, str4);
        intent.putExtra(KEY_REPLAY_POST_ID, str5);
        intent.putExtra(KEY_USER_IDENTITY, i);
        intent.putExtra(KEY_TAIL, smallTailInfo);
        intent.putExtra("anti", antiData);
        intent.putExtra(KEY_IS_SHOW_GO_TO_SUBJECT, z3);
        return this;
    }

    public SubPbActivityConfig createSubPbActivityConfig(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5, int i, SmallTailInfo smallTailInfo, AntiData antiData, boolean z3, ArrayList<IconData> arrayList) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra(KEY_IS_JUMP_FROM_PB, z);
        intent.putExtra(KEY_SHOW_KEYBOARD, z2);
        intent.putExtra(KEY_REPLAY_NAME, str4);
        intent.putExtra(KEY_REPLAY_POST_ID, str5);
        intent.putExtra(KEY_USER_IDENTITY, i);
        intent.putExtra(KEY_TAIL, smallTailInfo);
        intent.putExtra("anti", antiData);
        intent.putExtra(ICON_LIST, arrayList);
        intent.putExtra(KEY_IS_SHOW_GO_TO_SUBJECT, z3);
        return this;
    }

    public SubPbActivityConfig addBigImageData(ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z, int i) {
        if (concurrentHashMap != null && arrayList != null) {
            Intent intent = getIntent();
            Bundle bundle = new Bundle();
            ArrayList<String> arrayList2 = new ArrayList<>(concurrentHashMap.keySet());
            bundle.putStringArrayList(SUB_KEY_IMG_URL, arrayList2);
            bundle.putBoolean(SUB_KEY_IMG_CDN, z);
            bundle.putStringArrayList(SUB_KEY_IMG_SRC, arrayList);
            Iterator<String> it = arrayList2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    bundle.putSerializable(next, concurrentHashMap.get(next));
                }
            }
            bundle.putInt(SUB_KEY_IMG_OFFSET, i);
            intent.putExtra(KEY_IMG_URLS, bundle);
        }
        return this;
    }
}
