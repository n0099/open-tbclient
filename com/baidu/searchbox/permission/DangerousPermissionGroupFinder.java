package com.baidu.searchbox.permission;

import android.annotation.SuppressLint;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.p0.h;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class DangerousPermissionGroupFinder {
    public HashMap<String, String> mPermissionMap;

    public DangerousPermissionGroupFinder() {
        loadPermissionGroupInfo();
    }

    public void release() {
        this.mPermissionMap = null;
    }

    @SuppressLint({"InlinedApi"})
    private void loadPermissionGroupInfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.mPermissionMap = hashMap;
        hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE");
        this.mPermissionMap.put(h.i, "android.permission-group.STORAGE");
        this.mPermissionMap.put(h.c, "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.CALL_PHONE", "android.permission-group.PHONE");
        this.mPermissionMap.put("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.USE_SIP", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE");
        this.mPermissionMap.put("android.permission.READ_CONTACTS", "android.permission-group.CONTACTS");
        this.mPermissionMap.put("android.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS");
        this.mPermissionMap.put(h.f, "android.permission-group.CONTACTS");
        this.mPermissionMap.put(h.h, "android.permission-group.LOCATION");
        this.mPermissionMap.put(h.g, "android.permission-group.LOCATION");
        this.mPermissionMap.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission-group.MICROPHONE");
        this.mPermissionMap.put("android.permission.SEND_SMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.RECEIVE_SMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.READ_SMS", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS");
        this.mPermissionMap.put("android.permission.RECEIVE_MMS", "android.permission-group.SMS");
        this.mPermissionMap.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission-group.CAMERA");
        this.mPermissionMap.put("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR");
        this.mPermissionMap.put("android.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR");
        this.mPermissionMap.put("android.permission.BODY_SENSORS", "android.permission-group.SENSORS");
        this.mPermissionMap.put("android.permission.READ_CALL_LOG", DangerousPermissionManager.CALL_LOG_PERMISIION_GROUP);
        this.mPermissionMap.put("android.permission.WRITE_CALL_LOG", DangerousPermissionManager.CALL_LOG_PERMISIION_GROUP);
        this.mPermissionMap.put("android.permission.PROCESS_OUTGOING_CALLS", DangerousPermissionManager.CALL_LOG_PERMISIION_GROUP);
    }

    public String getPermssionGroupInfo(String str) {
        if (this.mPermissionMap.containsKey(str)) {
            return this.mPermissionMap.get(str);
        }
        return null;
    }
}
