package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes11.dex */
public class a {
    private static String axH = "";
    private com.baidu.live.alablmsdk.e.b axF;
    com.baidu.live.alablmsdk.module.b.a axG;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.axF = bVar;
    }

    public static void eK(String str) {
        com.baidu.live.alablmsdk.a.b.a.ag("legacy setCurrentRoomId " + str, "");
        axH = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.axG = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.axG.toJsonString();
        com.baidu.live.alablmsdk.a.b.a.ag("legacy putCurrentRoomInfo roomInfo " + jsonString, "");
        d.xp().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.axG != null) {
            this.axG.ayD = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.axG.toJsonString();
            com.baidu.live.alablmsdk.a.b.a.ag("legacy updateCurrentRoomStatus roomInfo " + jsonString, "");
            d.xp().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void xS() {
        d.xp().putString("legacy_room_info_kye", "");
    }

    public void xT() {
        com.baidu.live.alablmsdk.a.b.a.ag("legacy handleLongConnectionLegacyRoom ", "");
        if (this.axG != null && !TextUtils.isEmpty(this.axG.roomId) && this.axG.ayD == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.axF != null) {
            final String str = this.axG.roomId;
            if (this.axG.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy  closeRoom", "");
                this.axF.a(this.axG.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom onResult code=" + i, "");
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom success", "");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.axG.roomId)) {
                                com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom clearLegacyRoomInfo", "");
                                a.this.xS();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom hangout", "");
            this.axF.hangout(this.axG.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom hangout onResult code=" + i, "");
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.axG.roomId)) {
                            a.this.xS();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.ag("legacy long connect legacy closeRoom hangout fail code " + i, "");
                }
            });
        }
    }

    public void xU() {
        String string = d.xp().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.a.ag("legacy closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + axH, "");
        this.axG = com.baidu.live.alablmsdk.module.b.a.eR(string);
        if (this.axG != null && !TextUtils.isEmpty(this.axG.roomId) && !this.axG.roomId.equals(axH)) {
            if ((this.axG.ayD == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.axG.ayD == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.axF != null) {
                com.baidu.live.alablmsdk.a.b.a.ag("legacy closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.axG.roomId, "");
                if (this.axG.permission == UserPermission.OWNER.getPermission()) {
                    this.axF.a(this.axG.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.a.d("legacy handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.eA(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.xS();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d("legacy handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.a.eA(" handleInitLegacyRoom  hangout");
                this.axF.hangout(this.axG.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d("legacy handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.a.eA(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.xS();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        axH = "";
    }
}
