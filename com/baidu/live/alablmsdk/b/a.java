package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes4.dex */
public class a {
    private static String aAX = "";
    private com.baidu.live.alablmsdk.e.b aAV;
    com.baidu.live.alablmsdk.module.b.a aAW;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.aAV = bVar;
    }

    public static void fK(String str) {
        com.baidu.live.alablmsdk.a.b.ah("setCurrentRoomId " + str, "");
        aAX = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.aAW = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.aAW.toJsonString();
        com.baidu.live.alablmsdk.a.b.d(" putCurrentRoomInfo roomInfo=" + jsonString);
        com.baidu.live.alablmsdk.a.b.fJ(" putCurrentRoomInfo roomInfo " + jsonString);
        e.Bi().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.aAW != null) {
            this.aAW.aBN = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.aAW.toJsonString();
            com.baidu.live.alablmsdk.a.b.d(" updateCurrentRoomStatus  roomInfo=" + jsonString);
            com.baidu.live.alablmsdk.a.b.fJ(" updateCurrentRoomStatus roomInfo " + jsonString);
            e.Bi().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void Bv() {
        e.Bi().putString("legacy_room_info_kye", "");
    }

    public void Bw() {
        com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom ");
        com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom ");
        if (this.aAW != null && !TextUtils.isEmpty(this.aAW.roomId) && this.aAW.aBN == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.aAV != null) {
            final String str = this.aAW.roomId;
            if (this.aAW.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom  closeRoom");
                com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom  closeRoom");
                this.aAV.a(this.aAW.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom closeRoom  success");
                            com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom closeRoom  success");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.aAW.roomId)) {
                                com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                a.this.Bv();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom  hangout");
            com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom  hangout");
            this.aAV.hangout(this.aAW.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.aAW.roomId)) {
                            a.this.Bv();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.d(" handleLongConnectionLegacyRoom hangout fail , code=" + i);
                    com.baidu.live.alablmsdk.a.b.fJ(" handleLongConnectionLegacyRoom hangout fail code " + i);
                }
            });
        }
    }

    public void Bx() {
        String string = e.Bi().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.ah(" closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + aAX, "");
        this.aAW = com.baidu.live.alablmsdk.module.b.a.fQ(string);
        if (this.aAW != null && !TextUtils.isEmpty(this.aAW.roomId) && !this.aAW.roomId.equals(aAX)) {
            if ((this.aAW.aBN == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.aAW.aBN == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.aAV != null) {
                com.baidu.live.alablmsdk.a.b.ah(" closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.aAW.roomId, "");
                if (this.aAW.permission == UserPermission.OWNER.getPermission()) {
                    this.aAV.a(this.aAW.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.d(" handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.fJ(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.Bv();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.d(" handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.fJ(" handleInitLegacyRoom  hangout");
                this.aAV.hangout(this.aAW.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.d(" handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.fJ(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.Bv();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        aAX = "";
    }
}
