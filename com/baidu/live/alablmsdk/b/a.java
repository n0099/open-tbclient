package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes4.dex */
public class a {
    private static String azm = "";
    private com.baidu.live.alablmsdk.e.b azk;
    com.baidu.live.alablmsdk.module.b.a azl;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.azk = bVar;
    }

    public static void fE(String str) {
        com.baidu.live.alablmsdk.a.b.ag("setCurrentRoomId " + str, "");
        azm = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.azl = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.azl.toJsonString();
        com.baidu.live.alablmsdk.a.b.d(" putCurrentRoomInfo roomInfo=" + jsonString);
        com.baidu.live.alablmsdk.a.b.fD(" putCurrentRoomInfo roomInfo " + jsonString);
        e.Az().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.azl != null) {
            this.azl.aAc = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.azl.toJsonString();
            com.baidu.live.alablmsdk.a.b.d(" updateCurrentRoomStatus  roomInfo=" + jsonString);
            com.baidu.live.alablmsdk.a.b.fD(" updateCurrentRoomStatus roomInfo " + jsonString);
            e.Az().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void AM() {
        e.Az().putString("legacy_room_info_kye", "");
    }

    public void AN() {
        com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom ");
        com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom ");
        if (this.azl != null && !TextUtils.isEmpty(this.azl.roomId) && this.azl.aAc == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.azk != null) {
            final String str = this.azl.roomId;
            if (this.azl.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom  closeRoom");
                com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom  closeRoom");
                this.azk.a(this.azl.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom closeRoom  success");
                            com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom closeRoom  success");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.azl.roomId)) {
                                com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                a.this.AM();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom  hangout");
            com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom  hangout");
            this.azk.hangout(this.azl.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.azl.roomId)) {
                            a.this.AM();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom hangout fail , code=" + i);
                    com.baidu.live.alablmsdk.a.b.fD(" handleLongConnectionLegacyRoom hangout fail code " + i);
                }
            });
        }
    }

    public void AO() {
        String string = e.Az().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.ag(" closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + azm, "");
        this.azl = com.baidu.live.alablmsdk.module.b.a.fK(string);
        if (this.azl != null && !TextUtils.isEmpty(this.azl.roomId) && !this.azl.roomId.equals(azm)) {
            if ((this.azl.aAc == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.azl.aAc == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.azk != null) {
                com.baidu.live.alablmsdk.a.b.ag(" closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.azl.roomId, "");
                if (this.azl.permission == UserPermission.OWNER.getPermission()) {
                    this.azk.a(this.azl.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.d(" handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.fD(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.AM();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.d(" handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.fD(" handleInitLegacyRoom  hangout");
                this.azk.hangout(this.azl.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.d(" handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.fD(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.AM();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        azm = "";
    }
}
