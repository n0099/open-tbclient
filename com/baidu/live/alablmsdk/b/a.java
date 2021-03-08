package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes10.dex */
public class a {
    private static String azh = "";
    private com.baidu.live.alablmsdk.e.b azf;
    com.baidu.live.alablmsdk.module.b.a azg;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.azf = bVar;
    }

    public static void eQ(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("legacy setCurrentRoomId " + str, "");
        azh = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.azg = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.azg.toJsonString();
        com.baidu.live.alablmsdk.a.b.a.ag("legacy putCurrentRoomInfo roomInfo " + jsonString, "");
        d.xs().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.azg != null) {
            this.azg.aAd = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.azg.toJsonString();
            com.baidu.live.alablmsdk.a.b.a.ag("legacy updateCurrentRoomStatus roomInfo " + jsonString, "");
            d.xs().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void xV() {
        d.xs().putString("legacy_room_info_kye", "");
    }

    public void xW() {
        com.baidu.live.alablmsdk.a.b.a.ag("legacy handleLongConnectionLegacyRoom ", "");
        if (this.azg != null && !TextUtils.isEmpty(this.azg.roomId) && this.azg.aAd == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.azf != null) {
            final String str = this.azg.roomId;
            if (this.azg.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy  closeRoom", "");
                this.azf.a(this.azg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom onResult code=" + i, "");
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom success", "");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.azg.roomId)) {
                                com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom clearLegacyRoomInfo", "");
                                a.this.xV();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom hangout", "");
            this.azf.hangout(this.azg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom hangout onResult code=" + i, "");
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.azg.roomId)) {
                            a.this.xV();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom hangout fail code " + i, "");
                }
            });
        }
    }

    public void xX() {
        String string = d.xs().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.a.ag("legacy closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + azh, "");
        this.azg = com.baidu.live.alablmsdk.module.b.a.eX(string);
        if (this.azg != null && !TextUtils.isEmpty(this.azg.roomId) && !this.azg.roomId.equals(azh)) {
            if ((this.azg.aAd == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.azg.aAd == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.azf != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("legacy closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.azg.roomId, "");
                if (this.azg.permission == UserPermission.OWNER.getPermission()) {
                    this.azf.a(this.azg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.a.d("legacy handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.eG(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.xV();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d("legacy handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.a.eG(" handleInitLegacyRoom  hangout");
                this.azf.hangout(this.azg.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d("legacy handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.a.eG(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.xV();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        azh = "";
    }
}
